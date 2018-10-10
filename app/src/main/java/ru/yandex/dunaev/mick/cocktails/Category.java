package ru.yandex.dunaev.mick.cocktails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Category {
    @SerializedName("drinks")
    @Expose
    private List<CategoryDescriprion> drinks;

    public List<CategoryDescriprion> getDrinks() {
        return drinks;
    }

    public class CategoryDescriprion{
        @SerializedName("strCategory")
        @Expose
        private String strCategory;

        public CategoryDescriprion(String strCategory) {
            this.strCategory = strCategory;
        }

        public String getStrCategory() {
            return strCategory;
        }

        @Override
        public String toString() {
            return strCategory;
        }
    }


}
