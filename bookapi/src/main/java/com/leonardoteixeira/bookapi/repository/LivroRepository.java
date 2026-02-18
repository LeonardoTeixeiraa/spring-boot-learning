package com.leonardoteixeira.bookapi.repository;

import com.leonardoteixeira.bookapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long>{

    Optional<Livro> findByTitulo(String titulo);

    List<Livro> findByIdiomasContaining(String idioma);
}
