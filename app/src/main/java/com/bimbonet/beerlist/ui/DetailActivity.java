package com.bimbonet.beerlist.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bimbonet.beerlist.BaseActivity;
import com.bimbonet.beerlist.R;
import com.bimbonet.beerlist.data.model.BeerModel;
import com.bimbonet.beerlist.utilities.Constants;
import com.bumptech.glide.Glide;

public class DetailActivity extends BaseActivity {

    private BeerModel selectedBeer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intentFromMain = getIntent();
        selectedBeer = (BeerModel) intentFromMain.getSerializableExtra(Constants.SELECTED_BEER);
        if (selectedBeer != null) {
            showSelectedBeerDetail();
        }
    }

    public void showSelectedBeerDetail() {
        TextView tvBeerName= findViewById(R.id.tvBeerName);
        tvBeerName.setText(selectedBeer.getName());
        TextView tvBeerTagline = findViewById(R.id.tvBeerTagline);
        tvBeerTagline.setText(selectedBeer.getTagline());
        TextView tvBeerFirstBrewed = findViewById(R.id.tvBeerFirstBrewed);
        tvBeerFirstBrewed.setText(selectedBeer.getFirstBrewed());
        TextView tvBeerDescription = findViewById(R.id.tvBeerDescription);
        tvBeerDescription.setText(selectedBeer.getDescription());
        TextView tvBeerBrewerTips = findViewById(R.id.tvBeerBrewerTips);
        tvBeerBrewerTips.setText(selectedBeer.getBrewersTips());
        TextView tvBeerContributedBy = findViewById(R.id.tvBeerContributedBy);
        tvBeerContributedBy.setText(selectedBeer.getContributedBy());

        ImageView ivBeerImage = findViewById(R.id.ivBeerImage);
        Glide.with(this)
                .asBitmap()
                .fitCenter()
                .load(selectedBeer.getImageUrl())
                .into(ivBeerImage);
    }
}