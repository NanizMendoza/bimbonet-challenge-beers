package com.bimbonet.beerlist.data.repository;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.bimbonet.beerlist.data.database.BeerDao;
import com.bimbonet.beerlist.data.database.BeerDatabase;
import com.bimbonet.beerlist.data.model.BeerModel;
import com.bimbonet.beerlist.data.sharedPreferences.SharedPreferencesDataSource;
import com.bimbonet.beerlist.network.ApiClient;
import com.bimbonet.beerlist.network.ApiInterface;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BeerRepository {

    private final BeerDao beerDao;
    private final LiveData<List<BeerModel>> beerList;

    public BeerRepository(Application application) {
        SharedPreferencesDataSource.getInstance().init(application);
        BeerDatabase beerDatabase = BeerDatabase.getInstance(application);
        beerDao = beerDatabase.beerDao();
        beerList = beerDao.getAllBeers();

        if (!SharedPreferencesDataSource.getInstance().getIsSync()) {
            callGetBeerApi();
        }
    }

    public void insertAllBeers(List<BeerModel> beerList) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            beerDao.insertAllBeers(beerList);
        });
    }

    public LiveData<List<BeerModel>> getAllBeers() {
        return beerList;
    }

    public void callGetBeerApi() {
        Call<List<BeerModel>> call = ApiClient.getClient().create(ApiInterface.class).getAllBeers();
        call.enqueue(new Callback<List<BeerModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<BeerModel>> call, @NonNull Response<List<BeerModel>> response) {
                if (response.isSuccessful()) {
                    insertAllBeers(response.body());
                    SharedPreferencesDataSource.getInstance().setIsSync(true);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<BeerModel>> call, @NonNull Throwable t) {
                call.cancel();
            }
        });
    }
}
