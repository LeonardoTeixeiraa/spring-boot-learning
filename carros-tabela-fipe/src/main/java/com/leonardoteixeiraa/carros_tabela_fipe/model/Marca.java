package com.leonardoteixeiraa.carros_tabela_fipe.model;

public class Marca {
    private final int codigo;
    private final String nome;

    public Marca(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return
                "Cód" + codigo +
                "nome='" + nome + '\'';
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
}
