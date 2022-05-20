package com.example.kotlin_weather.View;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kotlin_weather.Model.Main;
import com.example.kotlin_weather.Model.WeatherResponse;
import com.example.kotlin_weather.Presenter.MainContract;
import com.example.kotlin_weather.Presenter.MainPresenter;
import com.example.kotlin_weather.R;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    public static String LATITUDE = "21";
    public static String LONGTITUDE = "105";
    public static String APP_ID = "2b0f1c2e6a3deab6d7f78949d22deb33";
    private MainPresenter mPresenter;
    private TextView textTemp, textLocation, textTempMin, textTempMax, textFeelLike;
    private ImageView imagWeatherIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        mPresenter = new MainPresenter(this);
        mPresenter.getCurrent(LATITUDE, LONGTITUDE, APP_ID);

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
    public void getInSuccess(WeatherResponse weatherResponse) {
       /* textLocation.setText(weatherResponse.sys.getCountry());
        textFeelLike.setText(String.valueOf(weatherResponse.getMain().getFeels_like()));
        textTemp.setText(String.valueOf(weatherResponse.getMain().temp));
        textTempMax.setText(String.valueOf(weatherResponse.getMain().temp_max));
        textTempMin.setText(String.valueOf(weatherResponse.getMain().temp_min));
        String icon = weatherResponse.getWeather().get(0).getIcon();
        Picasso.with(getApplicationContext()).load("http://openweathermap.org/img/wn/" + icon + ".png").into(imagWeatherIcon);*/
    }

    @Override
    public void getInFailure(String err) {
        Toast.makeText(getApplicationContext(), err, Toast.LENGTH_SHORT).show();
    }
}