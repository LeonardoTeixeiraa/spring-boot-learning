package com.leonardoteixeira.bookapi.model;

import jakarta.persistence.*;
import com.leonardoteixeira.bookapi.dto.GutendexLivroDTO;

import java.util.List;

@Entity
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "livro_autor",
            joinColumns = @JoinColumn(name = "livro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> autores;
    @Column(nullable = false)
    private String titulo;
    @Column(name = "numero_downloads")
    private Long numeroDownloads;

    @ElementCollection
    @CollectionTable(name = "livro_idiomas",
            joinColumns = @JoinColumn(name = "livro_id"))
    @Column(name = "idioma", nullable = false)
    private List<String> idiomas;

    public Long getId() {
        return id;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(Long numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }
}
