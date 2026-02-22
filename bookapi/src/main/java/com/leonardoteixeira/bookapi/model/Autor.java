package com.leonardoteixeira.bookapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.leonardoteixeira.bookapi.dto.GuntendexAutorDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autor",
        uniqueConstraints = @UniqueConstraint(columnNames = "nome"))
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Autor() {
    }

    @ManyToMany(mappedBy = "autores")
    @JsonIgnore
    private List<Livro> livros;
    @Column(nullable = false, unique = true)
    private String nome;
    private Integer anoNascimento;
    private Integer anoFalecimento;

    public Autor(GuntendexAutorDTO autorDTO) {
        this.nome = autorDTO.nome();
        this.anoNascimento = autorDTO.anoNascimento();
        this.anoFalecimento = autorDTO.anoFalecimento();
    }

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

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Integer getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(Integer anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }
}
