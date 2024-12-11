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
public class MobileCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // auto generates id
    private int brandId;
    private int categoryId;
    private String name;
    private String logo;

    public MobileCategory(int categoryId, String name,String logo) {
        this.categoryId = categoryId;
        this.name = name;
        this.logo = logo;
    }
}
