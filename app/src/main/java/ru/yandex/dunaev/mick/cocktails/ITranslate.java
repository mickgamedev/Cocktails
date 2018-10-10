package ru.yandex.dunaev.mick.cocktails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ITranslate {
    @POST("/api/v1.5/tr.json/translate")
    Call<Translate> getTranslate(@Query("key") String key,@Query("text") String text,@Query("lang") String lang);

}
