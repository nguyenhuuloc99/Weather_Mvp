package com.example.kotlin_weather.View;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kotlin_weather.Model.WeatherResponse;
import com.example.kotlin_weather.Presenter.PresenterInterface;
import com.example.kotlin_weather.Presenter.WeatherPresenter;
import com.example.kotlin_weather.R;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements PresenterInterface {
    public static String LATITUDE = "21";
    public static String LONGTITUDE = "105";
    public static String APP_ID = "2b0f1c2e6a3deab6d7f78949d22deb33";
    private WeatherPresenter presenter;
    private TextView textTemp, textLocation, textTempMin, textTempMax, textFeelLike;
    private ImageView imagWeatherIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        presenter = new WeatherPresenter(this);
        presenter.getWeatherResponse(LATITUDE, LONGTITUDE, APP_ID);

    }

    private void initViews() {
        textLocation = findViewById(R.id.textLocation);
        textTemp = findViewById(R.id.textTemp);
        textTempMin = findViewById(R.id.textTempMin);
        textTempMax = findViewById(R.id.textTempMax);
        textFeelLike = findViewById(R.id.textFeelLike);
        imagWeatherIcon = findViewById(R.id.imagWeatherIcon);
    }

    @Override
    public void getCurrent(WeatherResponse weatherReponse) {
        String icon = weatherReponse.getWeather().get(0).getIcon();
        Picasso.get().load("http://openweathermap.org/img/wn/" + icon + ".png").into(imagWeatherIcon);
    }
}