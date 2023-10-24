package com.bimbonet.beerlist.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.bimbonet.beerlist.data.repository.UserRepository;

public class LoginViewModel extends AndroidViewModel {

    private final UserRepository userRepository;
    private final MutableLiveData<String> username = new MutableLiveData<>();
    private final MutableLiveData<String> password = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isLogged = new MutableLiveData<>();

    public LoginViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
        isLogged.postValue(userRepository.getIsLogged());
        username.postValue(userRepository.getUsername());
        password.postValue(userRepository.getPassword());
    }

    public void onLogin(String newUsername, String newPassword) {
        isLogged.postValue(true);
        userRepository.onLogin(newUsername, newPassword, () -> {
            username.postValue(newUsername);
            password.postValue(newPassword);
        });
    }

    public MutableLiveData<String> getUsername() {
        return username;
    }

    public MutableLiveData<String> getPassword() {
        return password;
    }

    public MutableLiveData<Boolean> getIsLogged() {
        return isLogged;
    }
}
