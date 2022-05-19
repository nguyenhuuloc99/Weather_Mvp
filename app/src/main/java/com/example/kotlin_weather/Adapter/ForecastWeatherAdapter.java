package com.example.kotlin_weather.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.kotlin_weather.Model.List;
import com.example.kotlin_weather.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.TimeZone;

public class ForecastWeatherAdapter extends RecyclerView.Adapter<ForecastWeatherAdapter.ViewHolder> {
    private ArrayList<List> listWeather ;

    public ForecastWeatherAdapter(ArrayList<List> listWeather) {
        this.listWeather = listWeather;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SimpleDateFormat")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        List list = listWeather.get(position);
        DateFormat formatterUTC = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        formatterUTC.setTimeZone(TimeZone.getTimeZone("UTC")); // UTC timezone
        holder.textTime.setText(formatterUTC.format(list.getDt()));
        holder.textTemp.setText(String.valueOf(list.getMain().getTemp()));
        holder.textTempMax.setText(String.valueOf(list.getMain().getTempMax()));
        holder.textTempMin.setText(String.valueOf(list.getMain().getTempMin()));
    }

    @Override
    public int getItemCount() {
        return listWeather.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textTime, textTemp, textTempMin, textTempMax;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textTime = itemView.findViewById(R.id.textTime);
            textTemp = itemView.findViewById(R.id.textTemp);
            textTempMin = itemView.findViewById(R.id.textTempMin);
            textTempMax = itemView.findViewById(R.id.textTempMax);
        }
    }
}
