package com.example.kotlin_weather.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("dt")
    @Expose
    private Integer dateTime;
    @SerializedName("main")
    @Expose
    private Main main;
    public Integer getDt() {
        return dateTime;
    }

    public void setDt(Integer dt) {
        this.dateTime = dt;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
