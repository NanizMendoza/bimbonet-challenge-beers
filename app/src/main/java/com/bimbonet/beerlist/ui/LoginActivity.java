package com.bimbonet.beerlist.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bimbonet.beerlist.R;
import com.bimbonet.beerlist.viewModel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etLoginUsername);
        etPassword = findViewById(R.id.etLoginPassword);

        Button btnlogin = findViewById(R.id.btnLogin);
        btnlogin.setOnClickListener(view -> {
            validateLogin();
        });

        setObservers();
    }

    private void setObservers() {
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        loginViewModel.getUsername().observe(this, username -> etUsername.setText(username));
        loginViewModel.getPassword().observe(this, password -> etPassword.setText(password));
    }

    private void validateLogin() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        if (username.trim().equals("")) {
            Toast.makeText(getApplicationContext(), R.string.login_validate_username, Toast.LENGTH_LONG).show();
        }
        else if(password.trim().equals("")) {
            Toast.makeText(getApplicationContext(), R.string.login_validate_password, Toast.LENGTH_LONG).show();
        } else {
            loginViewModel.onLogin(username, password);
            Intent intentToMain = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intentToMain);
            finish();
        }
    }
}