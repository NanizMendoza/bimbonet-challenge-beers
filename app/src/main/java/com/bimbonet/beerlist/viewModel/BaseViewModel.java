package com.bimbonet.beerlist.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.bimbonet.beerlist.data.repository.UserRepository;

public class BaseViewModel extends AndroidViewModel {

    private final MutableLiveData<Boolean> isLogged = new MutableLiveData<>();
    private final UserRepository userRepository;

    public BaseViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
        isLogged.postValue(userRepository.getIsLogged());
    }

    public void onLogout() {
        isLogged.postValue(false);
        userRepository.onLogout();
    }

    public MutableLiveData<Boolean> getIsLogged() {
        return isLogged;
    }
}
