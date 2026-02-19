package com.leonardoteixeira.bookapi.repository;

import com.leonardoteixeira.bookapi.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    Optional<Autor> findByNome(String nome);
}
