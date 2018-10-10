package ru.yandex.dunaev.mick.cocktails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ICocktails {

    @GET("/api/json/v1/1/list.php?c=list")
    Call<Category> getCategoryList();

    @GET("/api/json/v1/1/filter.php")
    Call<CategoryCocktails> getCategoryDetails(@Query("c") String nameCategory);

    @GET("/api/json/v1/1/lookup.php")
    Call<DrinkDetails> getDrinkDetails(@Query("i") String id);
}
