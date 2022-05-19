package com.example.weather.View;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather.Adapter.ForecastWeatherAdapter;
import com.example.weather.Model.List;
import com.example.weather.Model.WeatherResponse;
import com.example.weather.Presenter.ForecastWeatherContract;
import com.example.weather.Presenter.ForecastWeatherPresenter;
import com.example.weather.R;

import java.util.ArrayList;

public class ForecastWeatherActivity extends AppCompatActivity implements ForecastWeatherContract.View {
    private RecyclerView recyerview;
    private ForecastWeatherPresenter forecastWeatherPresenter;
    public static String LATITUDE = "21";
    public static String LONGTITUDE = "105";
    public static String APP_ID = "2b0f1c2e6a3deab6d7f78949d22deb33";
    private ForecastWeatherAdapter weatherAdapter;
    private ArrayList<List> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyerview = findViewById(R.id.recyerview);
        forecastWeatherPresenter = new ForecastWeatherPresenter(this);
        forecastWeatherPresenter.getForecastWeatherData(LATITUDE, LONGTITUDE, APP_ID);
        recyerview.setLayoutManager(new LinearLayoutManager(this));
        recyerview.setHasFixedSize(true);
    }

    @Override
    public void getInSuccess(WeatherResponse weatherResponse) {
        list = (ArrayList<List>) weatherResponse.getList();
        weatherAdapter = new ForecastWeatherAdapter(list);
        recyerview.setAdapter(weatherAdapter);
        weatherAdapter.notifyDataSetChanged();
    }

    @Override
    public void getInFailure(String err) {
        Toast.makeText(getApplicationContext(), err, Toast.LENGTH_SHORT).show();
    }
}