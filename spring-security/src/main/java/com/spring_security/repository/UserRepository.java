package com.spring_security.repository;

import com.spring_security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT e FROM User  e JOIN e.roles WHERE e.username = (:username)" )
    public User findByUsername(@Param("username") String username);
}
