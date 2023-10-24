package com.bimbonet.beerlist.data.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.bimbonet.beerlist.data.model.BeerModel;
import com.bimbonet.beerlist.utilities.Constants;

import java.util.List;

@Dao
public interface BeerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllBeers(List<BeerModel> beerList);

    @Query("SELECT * FROM " + Constants.BEER_TABLE_NAME)
    LiveData<List<BeerModel>> getAllBeers();
}
