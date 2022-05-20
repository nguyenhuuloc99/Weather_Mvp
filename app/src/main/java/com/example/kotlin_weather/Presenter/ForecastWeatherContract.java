package com.example.kotlin_weather.Presenter;

import com.example.kotlin_weather.Model.WeatherResponse;

public interface ForecastWeatherContract {
    interface View {
        void getInSuccess(WeatherResponse weatherResponse);

        void getInFailure(String err);
    }

    interface Presenter {
        void getWeatherForecastData(String latitude, String longtitude, String app_id);

    }

}
