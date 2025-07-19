package com.leonardoTeixeira.design_patterns_spring.model;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
public class Cliente {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private long id;
    private String nome;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne
    private  Endereco endereco;

}
