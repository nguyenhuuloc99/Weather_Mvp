package com.example.kotlin_weather.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("temp")
    @Expose
    private Double temp;
    @SerializedName("feels_like")
    @Expose
    private Double feelsLike;
    @SerializedName("temp_min")
    @Expose
    private Double tempMin;
    @SerializedName("temp_max")
    @Expose
    private Double tempMax;

    public double getTemp() {
        return temp;
    }



    public Double getFeelsLike() {
        return feelsLike;
    }



    public Double getTempMin() {
        return tempMin;
    }



    public Double getTempMax() {
        return tempMax;
    }




}
