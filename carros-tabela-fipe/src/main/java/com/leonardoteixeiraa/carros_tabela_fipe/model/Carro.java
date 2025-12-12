package com.leonardoteixeiraa.carros_tabela_fipe.model;

import com.leonardoteixeiraa.carros_tabela_fipe.dto.CarroFipeDTO;

public class Carro {
    private final String nome;
    private final String ano;
    private String preco;
    private String tipoCombustivel;
    private String codigoFipe;

    public Carro(String nome, String ano) {
        this.nome = nome;
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Carro" +
                "\nnome ='" + nome + '\'' +
                "\nano ='" + ano + '\'' +
                "\npreco =" + preco +
                "\ntipoCombustivel ='" + tipoCombustivel + '\'' +
                "\ncodigoFipe ='" + codigoFipe + '\'';
    }

    public Carro(CarroFipeDTO dto) {
        this.nome = dto.getModelo();
        this.ano = dto.getAnoModelo() != null ? dto.getAnoModelo().toString() : null;
        this.preco = dto.getValor();
        this.tipoCombustivel = dto.getCombustivel();
        this.codigoFipe = dto.getCodigoFipe();
    }


    public String getNome() {
        return nome;
    }

    public String getAno() {
        return ano;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}
