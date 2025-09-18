package com.leonardoteixeira.cadastroDeUsuarios;

import com.leonardoteixeira.cadastroDeUsuarios.model.User;
import com.leonardoteixeira.cadastroDeUsuarios.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartApp implements CommandLineRunner {
    private final UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Marcel", "askj@43%&");
        repository.save(u1);
        User u2= new User(null, "Leonardo", "askj@56%&");
        repository.save(u2);
        User u3 = new User(null, "Bera", "askj347%&");
        repository.save(u3);
        User u4 = new User(null, "Maria", "fdg@43%&");
        repository.save(u4);
        User u5 = new User(null, "Fernanda", "2ferf@43%&");
        repository.save(u5);
    }

}
