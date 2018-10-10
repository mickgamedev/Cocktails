package ru.yandex.dunaev.mick.cocktails;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CocktailHelper {
    private static ICocktails sCocktails;
    private CocktailHelper(){}

    public static ICocktails getInstance(){
        if(sCocktails == null){
            sCocktails = new Retrofit.Builder()
                    .baseUrl("https://www.thecocktaildb.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ICocktails.class);
        }
        return sCocktails;
    }


}
