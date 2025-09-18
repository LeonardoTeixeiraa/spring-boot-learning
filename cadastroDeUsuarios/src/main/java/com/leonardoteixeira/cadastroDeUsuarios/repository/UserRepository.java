package com.leonardoteixeira.cadastroDeUsuarios.repository;

import com.leonardoteixeira.cadastroDeUsuarios.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
