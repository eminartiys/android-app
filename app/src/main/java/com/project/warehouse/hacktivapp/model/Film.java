package com.project.warehouse.hacktivapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eminartiys on 10/03/22.
 */

public class Film {

    @SerializedName("id")
    public String id;

    @SerializedName("title")
    public String title;

    @SerializedName("original_title")
    public String originalTitle;

    @SerializedName("image")
    public String image;

    @SerializedName("movie_banner")
    public String movieBanner;

    @SerializedName("description")
    public String description;

    @SerializedName("director")
    public String director;

    @SerializedName("producer")
    public String producer;
}
