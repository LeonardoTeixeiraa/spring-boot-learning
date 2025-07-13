package com.leonardoteixeira.aula_spring_postgresql;

import com.leonardoteixeira.aula_spring_postgresql.model.User;
import com.leonardoteixeira.aula_spring_postgresql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StartApp implements CommandLineRunner {

    @Autowired
    private UserRepository repository;
    @Override
    public void run(String... args) throws Exception {
        List<User> users = repository.findByName("Leonardo");
        for (User u : users) {
            System.out.println(u);
        }
    }

    private void insertUser(){
        User user = new User();
        user.setName("JOAO");
        user.setUsername("JAOfelix");
        user.setPassword("Jao122");
        repository.save(user);

        for (User u: repository.findAll()){
            System.out.println(u);
        }
    }



    }

