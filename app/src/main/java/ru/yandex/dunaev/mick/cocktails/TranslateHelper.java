package ru.yandex.dunaev.mick.cocktails;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TranslateHelper {
    private static ITranslate sITranslate;
    private TranslateHelper(){}

    public static ITranslate getInstance(){
        if(sITranslate == null){
            sITranslate = new Retrofit.Builder()
                    .baseUrl("https://translate.yandex.net")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ITranslate.class);
        }
        return sITranslate;
    }

}
