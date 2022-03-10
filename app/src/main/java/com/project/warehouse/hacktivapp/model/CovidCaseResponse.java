package com.project.warehouse.hacktivapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eminartiys on 10/03/22.
 */

public class CovidCaseResponse {

    @SerializedName("cases")
    public long cases;

    @SerializedName("deaths")
    public long deaths;

    @SerializedName("recovered")
    public long recovered;

}
