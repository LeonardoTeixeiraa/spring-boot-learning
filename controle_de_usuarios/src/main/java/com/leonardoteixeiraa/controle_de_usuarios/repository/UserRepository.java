package com.leonardoteixeiraa.controle_de_usuarios.repository;

import com.leonardoteixeiraa.controle_de_usuarios.handler.BusinessException;
import com.leonardoteixeiraa.controle_de_usuarios.handler.CampoObrigatorioException;
import com.leonardoteixeiraa.controle_de_usuarios.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    public void save(User user){
        if (user.getLogin() == null)
            throw new CampoObrigatorioException("Login");

        if (user.getPassword() == null)
            throw new CampoObrigatorioException("Password");

        if(user.getId() == null)
            System.out.println("SAVE - Recebendo o usuário na camada de repositório");
        else
            System.out.println("UPDATE - Recebendo o usuário na camada de repositório");
        System.out.println(user);
    }
    public void update(User user){
        System.out.println("UPDATE - Recebendo o usuário na camada de repositório");
        System.out.println(user);
    }
    public void remove(Integer id){
        System.out.println(String.format("DELETE/id - Recebendo o id: %d para excluir um usuário", id));
        System.out.println(id);
    }
    public List<User> listAll(){
        System.out.println("LIST - Listando os usários do sistema");
        List<User> users = new ArrayList<>();
        users.add(new User("leonardo","password"));
        users.add(new User("frank","masterpass"));
        return users;
    }
    public User findById(Integer id){
        System.out.println(String.format("FIND/id - Recebendo o id: %d para localizar um usuário", id));
        return new User("leonardo","password");
    }

    public void deleteById(Integer id){
        System.out.println(String.format("DELETE/id - Recebendo o id: %d para excluir um usuário", id));
        System.out.println(id);
    }
    public List<User> findAll(){
        System.out.println("LIST - Listando os usuários do sistema");
        List<User> users = new ArrayList<>();
        users.add(new User("leonardo", "password"));
        users.add(new User("frank","masterpass"));
        return users;
    }

    public User findByName(String username) {
        System.out.println(String.format("FIND/username - Recebendo o id: %s para localizar um usuário", username));
        return new User("leonardo","password");
    }
}
