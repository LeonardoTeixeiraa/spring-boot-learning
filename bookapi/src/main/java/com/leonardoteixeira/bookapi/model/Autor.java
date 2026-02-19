package com.leonardoteixeira.bookapi.model;

import com.leonardoteixeira.bookapi.dto.GuntendexAutorDTO;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "autor",
        uniqueConstraints = @UniqueConstraint(columnNames = "nome"))
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany(mappedBy = "autores")
    private List<Livro> livros;
    private String nome;
    private Date anoNascimento;
    private Date anoFalecimento;

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
