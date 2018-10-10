package ru.yandex.dunaev.mick.cocktails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DrinkDetails {
    public class Details{
        @SerializedName("strDrink")
        @Expose
        private String strDrink;

        @SerializedName("strInstructions")
        @Expose
        private String strInstructions;

        @SerializedName("strDrinkThumb")
        @Expose
        private String strDrinkThumb;

        @SerializedName("strIngredient1")
        @Expose
        private String strIngredient1;

        @SerializedName("strIngredient2")
        @Expose
        private String strIngredient2;

        @SerializedName("strIngredient3")
        @Expose
        private String strIngredient3;

        @SerializedName("strIngredient4")
        @Expose
        private String strIngredient4;

        @SerializedName("strIngredient5")
        @Expose
        private String strIngredient5;

        @SerializedName("strIngredient6")
        @Expose
        private String strIngredient6;

        @SerializedName("strIngredient7")
        @Expose
        private String strIngredient7;

        @SerializedName("strIngredient8")
        @Expose
        private String strIngredient8;

        @SerializedName("strIngredient9")
        @Expose
        private String strIngredient9;

        @SerializedName("strIngredient10")
        @Expose
        private String strIngredient10;

        @SerializedName("strIngredient11")
        @Expose
        private String strIngredient11;

        @SerializedName("strIngredient12")
        @Expose
        private String strIngredient12;

        @SerializedName("strIngredient13")
        @Expose
        private String strIngredient13;

        @SerializedName("strIngredient14")
        @Expose
        private String strIngredient14;

        @SerializedName("strIngredient15")
        @Expose
        private String strIngredient15;

        @SerializedName("strMeasure1")
        @Expose
        private String strMeasure1;

        @SerializedName("strMeasure2")
        @Expose
        private String strMeasure2;

        @SerializedName("strMeasure3")
        @Expose
        private String strMeasure3;

        @SerializedName("strMeasure4")
        @Expose
        private String strMeasure4;

        @SerializedName("strMeasure5")
        @Expose
        private String strMeasure5;

        @SerializedName("strMeasure6")
        @Expose
        private String strMeasure6;

        @SerializedName("strMeasure7")
        @Expose
        private String strMeasure7;

        @SerializedName("strMeasure8")
        @Expose
        private String strMeasure8;

        @SerializedName("strMeasure9")
        @Expose
        private String strMeasure9;

        @SerializedName("strMeasure10")
        @Expose
        private String strMeasure10;

        @SerializedName("strMeasure11")
        @Expose
        private String strMeasure11;

        @SerializedName("strMeasure12")
        @Expose
        private String strMeasure12;

        @SerializedName("strMeasure13")
        @Expose
        private String strMeasure13;

        @SerializedName("strMeasure14")
        @Expose
        private String strMeasure14;

        @SerializedName("strMeasure15")
        @Expose
        private String strMeasure15;


        public String getStrDrink() {
            return strDrink;
        }

        public String getStrInstructions() {
            return strInstructions;
        }

        public String getStrDrinkThumb() {
            return strDrinkThumb;
        }

        private String getMeasure(int i){
            switch (i){
                case 1:
                    return strMeasure1;
                case 2:
                    return strMeasure2;
                case 3:
                    return strMeasure3;
                case 4:
                    return strMeasure4;
                case 5:
                    return strMeasure5;
                case 6:
                    return strMeasure6;
                case 7:
                    return strMeasure7;
                case 8:
                    return strMeasure8;
                case 9:
                    return strMeasure9;
                case 10:
                    return strMeasure10;
                case 11:
                    return strMeasure11;
                case 12:
                    return strMeasure12;
                case 13:
                    return strMeasure13;
                case 14:
                    return strMeasure14;
                case 15:
                    return strMeasure15;
            }
            return "";
        }

        private String getIngredient(int i){
            switch (i){
                case 1:
                    return strIngredient1;
                case 2:
                    return strIngredient2;
                case 3:
                    return strIngredient3;
                case 4:
                    return strIngredient4;
                case 5:
                    return strIngredient5;
                case 6:
                    return strIngredient6;
                case 7:
                    return strIngredient7;
                case 8:
                    return strIngredient8;
                case 9:
                    return strIngredient9;
                case 10:
                    return strIngredient10;
                case 11:
                    return strIngredient11;
                case 12:
                    return strIngredient12;
                case 13:
                    return strIngredient13;
                case 14:
                    return strIngredient14;
                case 15:
                    return strIngredient15;
            }
            return "";
        }
        public List<String> getIngredients(){
            List<String> list = new ArrayList<>();
            for(int i = 1;i <= 15;i++){
                if(!getIngredient(i).equals("")) list.add(getIngredient(i) + " " + getMeasure(i));
            }
            return list;
        }

    }

    @SerializedName("drinks")
    @Expose
    private List<Details> drink;

    public List<Details> getDrink() {
        return drink;
    }
}
