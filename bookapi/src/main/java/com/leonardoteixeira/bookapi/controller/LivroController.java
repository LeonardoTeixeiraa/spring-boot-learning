package com.leonardoteixeira.bookapi.controller;

import com.leonardoteixeira.bookapi.dto.LivroDTO;
import com.leonardoteixeira.bookapi.model.Livro;
import com.leonardoteixeira.bookapi.service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping("/importar")
    public ResponseEntity<Livro> importarLivro(@RequestParam String titulo) {
        Livro livro = livroService.importarLivroApi(titulo);
        return ResponseEntity.ok(livro);
    }

    @GetMapping
    public ResponseEntity<LivroDTO> buscarPorTitulo(@RequestParam String titulo) {
        LivroDTO livro = livroService.buscarLivroPorTitulo(titulo);
        return ResponseEntity.ok(livro);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<LivroDTO>> listarTodos() {
        List<LivroDTO> livros = livroService.buscarTodosOsLivros();

        if (livros == null || livros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(livros);
    }

    @GetMapping("/idioma")
    public ResponseEntity<List<LivroDTO>> buscarPorIdioma(@RequestParam String idioma) {
        List<LivroDTO> livros = livroService.buscarLivroPorIdioma(idioma);

        if (livros == null || livros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(livros);
    }
}
