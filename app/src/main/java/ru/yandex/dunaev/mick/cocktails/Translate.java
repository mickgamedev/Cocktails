package ru.yandex.dunaev.mick.cocktails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Translate {
    @SerializedName("code")
    @Expose
    private int code;

    @SerializedName("lang")
    @Expose
    private String lang;

    @SerializedName("text")
    @Expose
    private List<String> text;

    public String getText(){
        return text.get(0);
    }
}
