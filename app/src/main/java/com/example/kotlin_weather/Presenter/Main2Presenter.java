package com.example.kotlin_weather.Presenter;

import androidx.annotation.NonNull;

import com.example.kotlin_weather.Model.WeatherResponse;
import com.example.kotlin_weather.RetrofitApi.RetrofitClient;
import com.example.kotlin_weather.RetrofitApi.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Presenter implements Main2Contract.Presenter {
    private Main2Contract.View view;
    private WeatherResponse weatherResponse;

    public Main2Presenter(Main2Contract.View view) {
        this.view = view;
    }

    @Override
    public void getFiveDay(String latitude, String longtitude, String app_id) {
        WeatherService weatherApi = RetrofitClient.getIntance().create(WeatherService.class);
        weatherApi.getWeatherData(latitude, longtitude, app_id).enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(@NonNull Call<WeatherResponse> call, @NonNull Response<WeatherResponse> response) {
                if (response.isSuccessful()) {
                    weatherResponse = response.body();
                    view.getInSuccess(weatherResponse);
                } else {
                    view.getInFailure("Failurre");
                }

            }

            @Override
            public void onFailure(@NonNull Call<WeatherResponse> call, @NonNull Throwable t) {
                view.getInFailure(t.getMessage());
            }
        });
    }
}
