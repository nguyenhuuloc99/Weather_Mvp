package com.example.weather.Presenter;

import com.example.weather.Model.WeatherResponse;

public interface ForecastWeatherContract {
    interface View {
        void getInSuccess(WeatherResponse weatherResponse);

        void getInFailure(String err);
    }

    interface Presenter {
        void getForecastWeatherData(String latitude, String longtitude, String app_id);

    }

}
