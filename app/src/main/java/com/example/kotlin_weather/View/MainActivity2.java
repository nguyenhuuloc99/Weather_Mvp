package com.example.kotlin_weather.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.kotlin_weather.Adapter.WeatherAdapter;
import com.example.kotlin_weather.Model.List;
import com.example.kotlin_weather.Model.WeatherResponse;
import com.example.kotlin_weather.Presenter.Main2Contract;
import com.example.kotlin_weather.Presenter.Main2Presenter;
import com.example.kotlin_weather.Presenter.MainContract;
import com.example.kotlin_weather.R;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements Main2Contract.View {
    private RecyclerView recyerview;
    private Main2Presenter main2Presenter;
    public static String LATITUDE = "21";
    public static String LONGTITUDE = "105";
    public static String APP_ID = "2b0f1c2e6a3deab6d7f78949d22deb33";
    private WeatherAdapter weatherAdapter;
    ArrayList<List> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyerview = findViewById(R.id.recyerview);
        main2Presenter = new Main2Presenter(this);
        main2Presenter.getFiveDay(LATITUDE, LONGTITUDE, APP_ID);
    }

    @Override
    public void getInSuccess(WeatherResponse weatherResponse) {
        list = weatherResponse.getList();
        recyerview.setLayoutManager(new LinearLayoutManager(this));
        recyerview.setHasFixedSize(true);
        weatherAdapter = new WeatherAdapter(list, getApplicationContext());
        recyerview.setAdapter(weatherAdapter);
    }

    @Override
    public void getInFailure(String err) {
        Toast.makeText(getApplicationContext(), err, Toast.LENGTH_SHORT).show();
    }
}