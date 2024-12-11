package com.alpha.shopybeebackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;


@NoArgsConstructor
@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // auto generates id
    private int id;
    private int userId;

    private String name;
    private String addressLine;
    private String city;
    private String state;
    @Nullable
    private String landmark;
    private String pincode;

    private String phone;

    public Address(int userId, String name , String addressLine, String city, String state, String landmark, String pincode,String phone) {
        this.userId = userId;
        this.name = name;
        this.addressLine = addressLine;
        this.city = city;
        this.state = state;
        this.landmark = landmark;
        this.pincode = pincode;
        this.phone=phone;
    }

    public Address(int id, String name, int userId, String addressLine, String city, String state, @Nullable String landmark, String pincode, String phone) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.addressLine = addressLine;
        this.city = city;
        this.state = state;
        this.landmark = landmark;
        this.pincode = pincode;
        this.phone = phone;
    }
}
