package com.leonardoteixeira.bookapi.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public record GuntendexAutorDTO(@JsonAlias("name") String nome,
                               @JsonAlias("birth_year") Integer anoNascimento,
                               @JsonAlias("death_year") Integer anoFalecimento)
{
}
