package com.leonardoteixeira.bookapi.dto;

import com.leonardoteixeira.bookapi.model.Autor;

import java.util.List;

public record LivroDTO(String titulo,
                       List<Autor> autores,
                       List<String> idiomas,
                       Long numero_downloads) {
}
