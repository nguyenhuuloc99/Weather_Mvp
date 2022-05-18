package com.example.kotlin_weather.Presenter;

import android.util.Log;

import com.example.kotlin_weather.Model.WeatherResponse;
import com.example.kotlin_weather.RetrofitApi.RetrofitClient;
import com.example.kotlin_weather.RetrofitApi.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract {

    private MainContract.View mView;
    private WeatherResponse weatherResponse;

    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getCurrent(String latitude, String longtitude, String app_id) {
        WeatherService weatherApi = RetrofitClient.getIntance().create(WeatherService.class);
        weatherApi.getCurrentWeatherData(latitude, longtitude, app_id).enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (response.isSuccessful()) {
                    weatherResponse = response.body();
                    mView.getInSuccess(weatherResponse);
                } else {
                    mView.getInFailure("Failurre");
                }

            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
