package com.spring_security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping
    public String welcome(){
        return "Welcome to my Spring boot Web API";
    }

    @GetMapping("/users")
    public String users(){
        return "Authorized user";
    }

    @GetMapping("/managers")
    public String managers() {
        return "Authorized managers";
    }
}
