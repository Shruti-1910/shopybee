package com.alpha.shopybeebackend.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@NoArgsConstructor
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // auto generates id
    private Long id;
    private String email;
    private String name;
    private String phone;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
