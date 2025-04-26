package com.leonardoteixeiraa.first_spring_app.controller;

import com.leonardoteixeiraa.first_spring_app.domain.User;
import com.leonardoteixeiraa.first_spring_app.service.HelloWorldService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    private HelloWorldService helloWorldService;

    //Construtor declarado manualmente, porém poderia ser substituído pela anotação @Autowired
    public HelloWorldController(HelloWorldService helloWorldService){
        this.helloWorldService = helloWorldService;
    }

    @GetMapping
    public String helloWorld(){
        return helloWorldService.HelloWorld() + " " + helloWorldService.firstApplicationMessage();
    }

    @PostMapping("/{id}")
    public String helloWorldPost(@PathVariable("id") String id, @RequestParam(value = "filter", defaultValue = "nenhum") String filter, @RequestBody User body){
        return "Hello World " + filter;
    }

}
