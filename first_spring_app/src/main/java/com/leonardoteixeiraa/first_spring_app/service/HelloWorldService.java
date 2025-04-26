package com.leonardoteixeiraa.first_spring_app.service;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    public String HelloWorld(){
        return "Hello World!";
    }

    public String firstApplicationMessage(){
        return "Esta é a minha primeira aplicação desenvolvida com Spring boot! ";
    }
}
