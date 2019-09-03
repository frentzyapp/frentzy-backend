package com.frentzy.backend.login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginRepository repository;

    LoginController(LoginRepository repository){
        this.repository = repository;
    }

    @GetMapping("/")
    List<Login> all(){
        System.out.println(repository.findAll());
        return repository.findAll();
    }
}
