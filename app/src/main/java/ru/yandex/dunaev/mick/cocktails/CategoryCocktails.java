package ru.yandex.dunaev.mick.cocktails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryCocktails {
    public class CocktailsDetails{
        @SerializedName("strDrink")
        @Expose
        private String strDrink;

        @SerializedName("strDrinkThumb")
        @Expose
        private String strDrinkThumb;

        @SerializedName("idDrink")
        @Expose
        private String idDrink;

        public String getStrDrink() {
            return strDrink;
        }

        public String getStrDrinkThumb() {
            return strDrinkThumb;
        }

        public String getIdDrink() {
            return idDrink;
        }

        @Override
        public String toString() {
            return strDrink;
        }
    }

    @SerializedName("drinks")
    @Expose
    private List<CocktailsDetails> drinks;

    public List<CocktailsDetails> getDrinks() {
        return drinks;
    }
}
