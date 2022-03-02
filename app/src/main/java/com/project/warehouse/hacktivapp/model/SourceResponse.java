package com.project.warehouse.hacktivapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by eminartiys on 02/03/22.
 */

public class SourceResponse {

    @SerializedName("sources")
    public List<Source> sources;
}
