package com.bimbonet.beerlist.network;

import com.bimbonet.beerlist.data.model.BeerModel;
import com.bimbonet.beerlist.utilities.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET(Constants.API_BEERS)
    Call<List<BeerModel>> getAllBeers();
}