package com.example.kotlin_weather.Presenter;

import androidx.annotation.NonNull;

import com.example.kotlin_weather.Model.WeatherResponse;
import com.example.kotlin_weather.RetrofitApi.RetrofitClient;
import com.example.kotlin_weather.RetrofitApi.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForecastWeatherPresenter implements ForecastWeatherContract.Presenter {
    private ForecastWeatherContract.View view;
    private WeatherResponse weatherResponse;

    public ForecastWeatherPresenter(ForecastWeatherContract.View view) {
        this.view = view;
    }


    @Override
    public void getWeatherForecastData(String latitude, String longtitude, String app_id) {
        WeatherService weatherApi = RetrofitClient.getIntance().create(WeatherService.class);
        weatherApi.getWeatherForecastData(latitude, longtitude, app_id).enqueue(new Callback<WeatherResponse>() {
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
