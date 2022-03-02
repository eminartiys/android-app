package com.project.warehouse.hacktivapp;

/**
 * Created by eminartiys on 14/02/22.
 */

class AndroidVersion {

    private String name;
    private String category;
    private String image;

    public AndroidVersion() {
    }

    public AndroidVersion(String name, String image, String category) {
        this.name = name;
        this.image = image;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
