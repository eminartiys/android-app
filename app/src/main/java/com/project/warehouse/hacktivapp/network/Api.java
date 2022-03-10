package com.project.warehouse.hacktivapp.network;

import com.project.warehouse.hacktivapp.model.CovidCaseResponse;
import com.project.warehouse.hacktivapp.model.Film;
import com.project.warehouse.hacktivapp.model.SourceResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by eminartiys on 02/03/22.
 */

public interface Api {

    String BASE_URL = "https://newsapi.org/v1/";
    String BASE_URL_GHIBLI = "https://ghibliapi.herokuapp.com/";
    String BASE_URL_COVID = "https://corona.lmao.ninja/v2/";

    @GET("sources")
    Call<SourceResponse> getSource();

    @GET("all")
    Call<CovidCaseResponse> getAllCases();

    @GET("states")
    Call<List<CovidCaseResponse>> getAllStatesCases();

    // Ghibli region
    @GET("films")
    Call<List<Film>> getAllFilms();
}
