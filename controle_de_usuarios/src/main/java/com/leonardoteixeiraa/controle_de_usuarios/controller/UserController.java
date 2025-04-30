package com.leonardoteixeiraa.controle_de_usuarios.controller;

import com.leonardoteixeiraa.controle_de_usuarios.model.User;
import com.leonardoteixeiraa.controle_de_usuarios.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users") // centraliza as requisições do controller como "users"
public class UserController {
    @Autowired
    private UserRepository repository;
    @GetMapping()
    public List<User> getUsers(){
        return repository.findAll();
    }
    @GetMapping("/{username}")
    public User getOneUser(@PathVariable("username") String username){
        return repository.findByName(username);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        repository.deleteById(id);
    }
    @PostMapping()
    public void postUser(@RequestBody User user){
        repository.save(user);
    }
    @PutMapping()
    public void putUser(@RequestBody User user){
        repository.save(user);
    }

}
