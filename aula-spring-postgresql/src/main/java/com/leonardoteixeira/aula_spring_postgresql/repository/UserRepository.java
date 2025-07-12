package com.leonardoteixeira.aula_spring_postgresql.repository;

import com.leonardoteixeira.aula_spring_postgresql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Integer> {

}

