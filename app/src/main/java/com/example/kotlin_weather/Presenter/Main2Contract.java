package com.example.kotlin_weather.Presenter;

import com.example.kotlin_weather.Model.WeatherResponse;

public interface Main2Contract {
    interface View {
        void getInSuccess(WeatherResponse weatherResponse);

        void getInFailure(String err);
    }

    interface Presenter {
        void getFiveDay(String latitude, String longtitude, String app_id);

    }
}
