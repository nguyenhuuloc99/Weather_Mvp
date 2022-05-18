package com.example.kotlin_weather.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.kotlin_weather.Model.List;
import com.example.kotlin_weather.Model.WeatherResponse;
import com.example.kotlin_weather.Presenter.MainContract;
import com.example.kotlin_weather.Presenter.MainPresenter;
import com.example.kotlin_weather.R;
import com.example.kotlin_weather.Adapter.WeatherAdapter;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements MainContract.View {
    public static String LATITUDE = "21";
    public static String LONGTITUDE = "105";
    public static String APP_ID = "2b0f1c2e6a3deab6d7f78949d22deb33";
    private MainPresenter mPresenter;
    private RecyclerView recyclerview;
    private WeatherAdapter weatherAdapter;
    ArrayList<List> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mPresenter = new MainPresenter(this);
        mPresenter.getCurrent(LATITUDE, LONGTITUDE, APP_ID);
        recyclerview = findViewById(R.id.recyerview);
    }

    @Override
    public void getInSuccess(WeatherResponse weatherResponse) {
        list = weatherResponse.getList();
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setHasFixedSize(true);
        weatherAdapter = new WeatherAdapter(list, getApplicationContext());
        recyclerview.setAdapter(weatherAdapter);
        Log.d("Tag", weatherResponse.getCod());
    }

    @Override
    public void getInFailure(String err) {
        Toast.makeText(getApplicationContext(), err, Toast.LENGTH_SHORT).show();
    }
}