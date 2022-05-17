package com.example.kotlin_weather.Presenter;

import com.example.kotlin_weather.Model.WeatherResponse;
import com.example.kotlin_weather.RetrofitApi.RetrofitClient;
import com.example.kotlin_weather.RetrofitApi.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherPresenter {

    private PresenterInterface mPresenter;
    private WeatherResponse weatherResponse;

    public WeatherPresenter(PresenterInterface Presenter) {
        this.mPresenter = Presenter;
    }

    public WeatherResponse getWeatherResponse(String latidue, String longtidue, String app_id) {
        WeatherService weatherApi = RetrofitClient.getIntance().create(WeatherService.class);
        weatherApi.getCurrentWeatherData(latidue, longtidue, app_id).enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (response.isSuccessful()) {
                    weatherResponse = response.body();
                    mPresenter.getCurrent(weatherResponse);
                }

            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {

            }
        });
        return weatherResponse;
    }
}
