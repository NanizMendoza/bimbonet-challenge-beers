package com.bimbonet.beerlist.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.bimbonet.beerlist.data.model.BeerModel;
import com.bimbonet.beerlist.utilities.Constants;

@Database(entities = {BeerModel.class}, version = 1)
public abstract class BeerDatabase extends RoomDatabase {

    public abstract BeerDao beerDao();
    private static volatile BeerDatabase INSTANCE;

    public static synchronized BeerDatabase getInstance(Context context) {
        if(INSTANCE == null){
            synchronized (BeerDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BeerDatabase.class, Constants.DATABASE_NAME).build();
                }
            }
        }
        return INSTANCE;
    }
}
