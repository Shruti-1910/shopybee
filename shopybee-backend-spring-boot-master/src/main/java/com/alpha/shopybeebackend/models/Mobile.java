package com.alpha.shopybeebackend.models;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Mobile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // auto generates id
    private int productId; // Id of the mobile
    private int brandId;
    private String name; // Name of the mobile
    private String mainImage;
    @Column(length = 100000)
    private String description; // Description of the mobile device
    private int ram; // RAM size in GB
    private double price; // Price of the item
    private int storage; // Internal memory of mobile device in GB
    private String brand; // Brand name of the mobile device
    private String batteryDetail; // Battery detail
    private int batteryBackup; // battery backup in mAH
    private int quantity; // quantity of this mobile device left in stock
    private int warranty; // Warranty in no. of years
    private double discount; // discount offered ( can vary time to time )
    private String
            operatingSystem; // Operating system of the device ( for example : Android 12 )
    private String processor; // for example : Snapdragon 636
    private String display; // Device resolution in height
    private String type; // Type will be mobile for this product
    private String simCardSlot; // Dual or Single sim
    private int frontCamera; // for example 13 MP, can be null if the device has no front camera
    private int rearCamera; // for example 13 MP
    private String itemsInBox; // single string separated by ','
    //@Column(name="images")
    @Column(length = 100000)
    private String images;

    public Mobile(int brandId, String images,String name, String mainImage, String description, int ram, double price, int storage, String brand, String batteryDetail, int batteryBackup, int quantity, int warranty, double discount, String operatingSystem, String processor, String display, String type, String simCardSlot, int frontCamera, int rearCamera, String itemsInBox) {
        this.brandId = brandId;
        this.name = name;
        this.images=images;
        this.mainImage = mainImage;
        this.description = description;
        this.ram = ram;
        this.price = price;
        this.storage = storage;
        this.brand = brand;
        this.batteryDetail = batteryDetail;
        this.batteryBackup = batteryBackup;
        this.quantity = quantity;
        this.warranty = warranty;
        this.discount = discount;
        this.operatingSystem = operatingSystem;
        this.processor = processor;
        this.display = display;
        this.type = type;
        this.simCardSlot = simCardSlot;
        this.frontCamera = frontCamera;
        this.rearCamera = rearCamera;
        this.itemsInBox = itemsInBox;
    }

    public Mobile(int id, String mainImage) {
        this.productId = id;
        this.mainImage = mainImage;
    }
}
