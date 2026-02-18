package com.leonardoteixeira.bookapi.repository;

import com.leonardoteixeira.bookapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long>{
}
