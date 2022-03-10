package com.project.warehouse.hacktivapp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by eminartiys on 02/03/22.
 */

public class RetrofitClient {

    private static RetrofitClient instance = null;
    private Api myAPI;

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL_GHIBLI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myAPI = retrofit.create(Api.class);
    }

    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }

        return instance;
    }

    public Api getMyAPI() {
        return myAPI;
    }

}
