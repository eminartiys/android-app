package com.project.warehouse.hacktivapp.network;

import com.project.warehouse.hacktivapp.model.Source;
import com.project.warehouse.hacktivapp.model.SourceResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by eminartiys on 02/03/22.
 */

public interface Api {

    String BASE_URL = "https://newsapi.org/v1/";

    @GET("sources")
    Call<SourceResponse> getSource();


}
