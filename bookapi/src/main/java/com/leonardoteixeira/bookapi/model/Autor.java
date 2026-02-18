package com.leonardoteixeira.bookapi.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany(mappedBy = "autores")
    private List<Livro> livros;
    private String nome;
    private Date anoNascimento;
    private Date anoFalecimento;

    public Long getId() {
        return id;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Date anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Date getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(Date anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }
}
