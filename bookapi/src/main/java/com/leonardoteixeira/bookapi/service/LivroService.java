package com.leonardoteixeira.bookapi.service;

import com.leonardoteixeira.bookapi.dto.GuntendexAutorDTO;
import com.leonardoteixeira.bookapi.dto.GutendexLivroDTO;
import com.leonardoteixeira.bookapi.dto.LivroDTO;
import com.leonardoteixeira.bookapi.model.Autor;
import com.leonardoteixeira.bookapi.model.Livro;
import com.leonardoteixeira.bookapi.repository.AutorRepository;
import com.leonardoteixeira.bookapi.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository livroRepository;
    private final GuntendexClient client;
    private final ConverteDados conversor;
    private final  AutorRepository autorRepository;

    public LivroService(LivroRepository livroRepository, GuntendexClient client, ConverteDados conversor, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.client = client;
        this.conversor = conversor;
        this.autorRepository = autorRepository;
    }

    private Livro importarLivroApi(String titulo){
        String tituloFormatado = URLEncoder.encode(titulo, StandardCharsets.UTF_8);
        String url = "https://gutendex.com/books/?search=" + tituloFormatado;
        String json = client.obterDados(url);

        GutendexLivroDTO dto = conversor.obterDados(json, GutendexLivroDTO.class);

        List<Autor> autores = buscarOuCriarAutores(dto.autores());

        Livro livro = new Livro();
        livro.setTitulo(dto.titulo());
        livro.setNumeroDownloads(dto.numeroDownloads());
        livro.setIdiomas(dto.idiomas());
        livro.setAutores(autores);
        return livroRepository.save(livro);
    }

    private List<Autor> buscarOuCriarAutores(List<GuntendexAutorDTO> autoresDTO) {
        return autoresDTO.stream()
                .map(a -> autorRepository.findByNome(a.nome())
                        .orElseGet(() -> autorRepository.save(new Autor(a))))
                .toList();
    }

    private LivroDTO buscarLivroPorTitulo(String titulo){
        Optional<Livro> livroOpt = livroRepository.findByTitulo(titulo);
        if (livroOpt.isEmpty()) {
           importarLivroApi(titulo);
           livroOpt = livroRepository.findByTitulo(titulo);
        }
        Livro l = livroOpt.orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        return new LivroDTO(l.getTitulo(), l.getAutores(), l.getIdiomas(), l.getNumeroDownloads());
    }

    private List<LivroDTO> buscarTodosOsLivros(){
        List<Livro> livros = livroRepository.findAll();

        if (livros.isEmpty()){
            return null;
        }
        return livros.stream()
                .map(l -> new LivroDTO(l.getTitulo(), l.getAutores(), l.getIdiomas(), l.getNumeroDownloads()))
                .toList();
    }

    private List<LivroDTO> buscarLivroPorIdioma(String idioma){
        List<Livro> livros = livroRepository.findByIdiomasContaining(idioma);
        if (livros.isEmpty()){
            return null;
        }
        return livros.stream()
                .map(l -> new LivroDTO(l.getTitulo(), l.getAutores(), l.getIdiomas(), l.getNumeroDownloads()))
                .toList();
    }
}
