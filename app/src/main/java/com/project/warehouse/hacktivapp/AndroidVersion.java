package com.project.warehouse.hacktivapp;

/**
 * Created by eminartiys on 14/02/22.
 */

class AndroidVersion {

    private String name;
    private int image;

    public AndroidVersion(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}
