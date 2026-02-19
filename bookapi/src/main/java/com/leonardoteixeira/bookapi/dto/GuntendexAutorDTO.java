package com.leonardoteixeira.bookapi.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.Date;

public record GuntendexAutorDTO(@JsonAlias("name") String nome,
                               @JsonAlias("birth_year") Date anoNascimento,
                               @JsonAlias("death_year") Date anoFalecimento)
{
}
