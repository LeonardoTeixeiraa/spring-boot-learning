package com.leonardoteixeiraa.controle_de_usuarios.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private Integer id;
    private String login;
    private String password;
    public User(){}
    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString(){
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
