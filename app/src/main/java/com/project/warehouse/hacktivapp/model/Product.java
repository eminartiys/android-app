package com.project.warehouse.hacktivapp.model;

/**
 * Created by eminartiys on 17/03/22.
 */

public class Product {

    private int id;
    private String name;
    private int quantity;
    private String image;
    private String description;

    public Product() {
    }

    public Product(String name, int quantity, String image, String description) {
        this.name = name;
        this.quantity = quantity;
        this.image = image;
        this.description = description;
    }

    public Product(int id, String name, int quantity, String image, String description) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.image = image;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
