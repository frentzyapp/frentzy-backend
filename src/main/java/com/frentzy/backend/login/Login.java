package com.frentzy.backend.login;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="login")
public class Login {
    private @Id @GeneratedValue(strategy = GenerationType.AUTO)Long id;
    private String password;

    Login(){};

    Login(Long id, String password){
        this.id = id;
        this.password = password;
    }
}

