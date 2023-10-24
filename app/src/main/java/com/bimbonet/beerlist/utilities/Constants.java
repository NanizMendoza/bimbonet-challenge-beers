package com.bimbonet.beerlist.utilities;

public class Constants {

    // Database
    public static final String DATABASE_NAME = "beer_database";
    public static final String BEER_TABLE_NAME = "tbl_beer";

    // Network
    public static final String BASE_URL = "https://api.punkapi.com/v2/";
    public static final String API_BEERS = "beers?page=1";

    // SharedPreferences
    public static final String PREFERENCES_FILENAME = "beerPreferences";
    public static final String PREFERENCES_USERNAME_KEY = "usernameKey";
    public static final String PREFERENCES_PASSWORD_KEY = "passwordKey";
    public static final String PREFERENCES_IS_SYNC_KEY = "isSyncKey";
    public static final String PREFERENCES_IS_LOGGED_KEY = "isLoggedKey";

    // DetailActivity
    public static final String SELECTED_BEER = "selectedBeer";
}
