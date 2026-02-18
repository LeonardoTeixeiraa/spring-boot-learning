package com.leonardoteixeira.bookapi.service;

import com.leonardoteixeira.bookapi.dto.GutendexLivroDTO;
import com.leonardoteixeira.bookapi.model.Livro;
import com.leonardoteixeira.bookapi.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class LivroService {

    private LivroRepository livroRepository;
    private GuntendexClient client;
    private ConverteDados conversor;

    public LivroService(LivroRepository livroRepository, GuntendexClient client, ConverteDados conversor) {
        this.livroRepository = livroRepository;
        this.client = client;
        this.conversor = conversor;
    }

    private Livro buscarLivroPorTituloAPI(String titulo){
        String tituloFormatado = URLEncoder.encode(titulo, StandardCharsets.UTF_8);
        String url = "https://gutendex.com/books/?search=" + tituloFormatado;
        String json = client.obterDados(url);

        GutendexLivroDTO dto = conversor.obterDados(json, GutendexLivroDTO.class);
        return new Livro(dto);
    }
}
