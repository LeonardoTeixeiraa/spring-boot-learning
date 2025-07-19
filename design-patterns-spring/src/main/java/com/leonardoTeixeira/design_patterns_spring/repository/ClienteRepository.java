package com.leonardoTeixeira.design_patterns_spring.repository;

import com.leonardoTeixeira.design_patterns_spring.model.Cliente;
import feign.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
