package com.bimbonet.beerlist.data.repository;

import android.app.Application;

import com.bimbonet.beerlist.data.sharedPreferences.SharedPreferencesDataSource;
import com.bimbonet.beerlist.interfaces.LoginCallback;

public class UserRepository {

    private final String username;
    private final String password;
    private final Boolean isLogged;

    public UserRepository(Application application) {
        SharedPreferencesDataSource.getInstance().init(application);
        username = SharedPreferencesDataSource.getInstance().getUsername();
        password = SharedPreferencesDataSource.getInstance().getPassword();
        isLogged = SharedPreferencesDataSource.getInstance().getIsLogged();
    }

    public void onLogin(String username, String password, LoginCallback loginCallback) {
        setIsLogged(true);
        setUsername(username);
        setPassword(password);
        loginCallback.onSuccess();
    }

    public void onLogout() {
        setIsLogged(false);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        SharedPreferencesDataSource.getInstance().setUsername(username);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        SharedPreferencesDataSource.getInstance().setPassword(password);
    }

    public Boolean getIsLogged() {
        return isLogged;
    }

    public void setIsLogged(Boolean isLogged) {
        SharedPreferencesDataSource.getInstance().setIsLogged(isLogged);
    }
}
