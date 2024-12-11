package com.alpha.shopybeebackend.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@NoArgsConstructor
@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // auto generates id
    private int categoryId;
    private String name;
    private String image;

    public Category(String name, String image) {
        this.name = name;
        this.image = image;
    }
}
