package com.example.kotlin_weather.Presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.kotlin_weather.Model.WeatherResponse;
import com.example.kotlin_weather.RetrofitApi.RetrofitClient;
import com.example.kotlin_weather.RetrofitApi.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter {
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
            public void onResponse(@NonNull Call<WeatherResponse> call, @NonNull Response<WeatherResponse> response) {
                if (response.isSuccessful()) {
                    weatherResponse = response.body();
                    mView.getInSuccess(weatherResponse);
                } else {
                    mView.getInFailure("Failurre");
                }

            }

            @Override
            public void onFailure(@NonNull Call<WeatherResponse> call, @NonNull Throwable t) {
                mView.getInFailure(t.getMessage());
            }
        });
    }


}
