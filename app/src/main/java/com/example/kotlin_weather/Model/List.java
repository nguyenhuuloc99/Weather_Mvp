package com.example.kotlin_weather.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class List {
    public List() {
    }

    @SerializedName("dt")
    @Expose
    private Long dt;
    @SerializedName("main")
    @Expose
    private Main main;
    @SerializedName("weather")
    @Expose
    private ArrayList<Weather> weather = null;

    public Main getMain() {
        return main;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public Long getDt() {
        return dt;
    }
}
