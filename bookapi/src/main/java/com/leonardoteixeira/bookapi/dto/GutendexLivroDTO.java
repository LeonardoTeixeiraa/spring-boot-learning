package com.leonardoteixeira.bookapi.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.leonardoteixeira.bookapi.model.Autor;
import org.springframework.boot.jackson.autoconfigure.JacksonProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GutendexLivroDTO(@JsonAlias("title") String titulo,
                               @JsonAlias("authors") List<Autor> autores,
                               @JsonAlias("languanges") List<String> idiomas,
                               @JsonAlias("download_count") Long numeroDownloads) {
}
