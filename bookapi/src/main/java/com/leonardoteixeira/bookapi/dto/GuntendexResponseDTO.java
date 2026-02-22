package com.leonardoteixeira.bookapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GuntendexResponseDTO(List<GutendexLivroDTO> results)
{
}
