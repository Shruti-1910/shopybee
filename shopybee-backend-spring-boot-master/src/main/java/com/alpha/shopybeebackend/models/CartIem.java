package com.alpha.shopybeebackend.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CartIem {

    int productId;
    private String name;
    private String mainImage;
    private double price;

    private double discount;

    public CartIem(int productId,String name, String mainImage, double price,double discount) {
        this.name = name;
        this.productId=productId;
        this.mainImage = mainImage;
        this.price = price;
        this.discount = discount;
    }
}
