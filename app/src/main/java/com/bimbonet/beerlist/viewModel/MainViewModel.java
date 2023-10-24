package com.bimbonet.beerlist.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.bimbonet.beerlist.data.model.BeerModel;
import com.bimbonet.beerlist.data.repository.BeerRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private final LiveData<List<BeerModel>> beerList;

    public MainViewModel(@NonNull Application application) {
        super(application);
        BeerRepository beerRepository = new BeerRepository(application);
        beerList = beerRepository.getAllBeers();
    }

    public LiveData<List<BeerModel>> getAllBeers() {
        return beerList;
    }

}
