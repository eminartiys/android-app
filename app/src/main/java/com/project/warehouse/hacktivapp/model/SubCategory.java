package com.project.warehouse.hacktivapp.model;

/**
 * Created by eminartiys on 17/03/22.
 */

public class SubCategory {

    private int id;
    private String name;
    private String image;
    private int parentCategoryId;

    public SubCategory() {
    }

    public SubCategory(String name, String image, int parentCategoryId) {
        this.name = name;
        this.image = image;
        this.parentCategoryId = parentCategoryId;
    }

    public SubCategory(int id, String name, String image, int parentCategoryId) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.parentCategoryId = parentCategoryId;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(int parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }
}
