package com.bimbonet.beerlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bimbonet.beerlist.ui.LoginActivity;
import com.bimbonet.beerlist.viewModel.BaseViewModel;

public class BaseActivity extends AppCompatActivity {

    private BaseViewModel baseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        baseViewModel = new ViewModelProvider(this).get(BaseViewModel.class);
        baseViewModel.getIsLogged().observe(this, isLogged -> {
            if (!isLogged) {
                Intent intentToLogin = new Intent(BaseActivity.this, LoginActivity.class);
                intentToLogin.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intentToLogin);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logout_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.itemLogout) {
            baseViewModel.onLogout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
