package com.project.warehouse.hacktivapp;

/**
 * Created by eminartiys on 14/02/22.
 */

class AndroidVersion {

    private String name;
    private String image;

    public AndroidVersion(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}
