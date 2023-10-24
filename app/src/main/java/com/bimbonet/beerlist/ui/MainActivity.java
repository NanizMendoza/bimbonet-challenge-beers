package com.bimbonet.beerlist.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bimbonet.beerlist.BaseActivity;
import com.bimbonet.beerlist.R;
import com.bimbonet.beerlist.adapter.BeerAdapter;
import com.bimbonet.beerlist.data.model.BeerModel;
import com.bimbonet.beerlist.utilities.Constants;
import com.bimbonet.beerlist.viewModel.MainViewModel;
import com.bimbonet.beerlist.viewModel.LoginViewModel;

import java.util.List;

public class MainActivity extends BaseActivity {

    private List<BeerModel> beerList;
    private RecyclerView rvBeerList;
    private RelativeLayout rlProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rlProgressBar = findViewById(R.id.rlProgressBar);

        rvBeerList = findViewById(R.id.rvBeerList);
        rvBeerList.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));

        setObservers();
        hideActionBar();
    }

    private void setObservers() {
        LoginViewModel loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        loginViewModel.getIsLogged().observe(this, isLogged -> {
            if (isLogged) {
                showActionBar();
                rvBeerList.setVisibility(View.VISIBLE);
            }
            rlProgressBar.setVisibility(View.GONE);
        });

        MainViewModel mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.getAllBeers().observe(this, beerList -> {
            this.beerList = beerList;
            if (beerList.size() != 0) {
                populateBeerList();
            }
        });
    }

    public void populateBeerList() {
        BeerAdapter beerAdapter = new BeerAdapter(getApplicationContext(), beerList, (position) -> {
            Intent intentToDetail = new Intent(getApplicationContext(), DetailActivity.class);
            BeerModel selectedBeer = beerList.get(position);
            intentToDetail.putExtra(Constants.SELECTED_BEER, selectedBeer);
            startActivity(intentToDetail);
        });
        rvBeerList.setAdapter(beerAdapter);
    }

    private void showActionBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().show();
        }
    }

    private void hideActionBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}