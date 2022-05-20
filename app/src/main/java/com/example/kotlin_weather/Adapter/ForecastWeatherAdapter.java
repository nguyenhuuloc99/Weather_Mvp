package com.example.kotlin_weather.Adapter;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;


import com.example.kotlin_weather.Model.Weather;
import com.example.kotlin_weather.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class ForecastWeatherAdapter extends RecyclerView.Adapter<ForecastWeatherAdapter.ViewHolder> {
    private ArrayList<Weather> listWeather;

    public ForecastWeatherAdapter(ArrayList<Weather> listWeather) {
        this.listWeather = listWeather;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather, parent, false);
        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @SuppressLint("SimpleDateFormat")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Weather list = listWeather.get(position);
        Date date = new Date(list.getDt() * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
        String formattedDate = sdf.format(date);
        holder.textTime.setText(formattedDate);
        double temp = list.getMain().getTemp() - 273;
        double tempMax = list.getMain().getTempMax() - 273;
        double tempMin = list.getMain().getTempMin() - 273;
        String tempString = String.format("%.02f", temp);
        String tempMaxString = String.format("%.02f", tempMax);
        String tempMinString = String.format("%.02f", tempMin);
        holder.textTemp.setText(tempString + (char) 0x00B0 + " C");
        holder.textTempMax.setText(tempMaxString + (char) 0x00B0 + " C");
        holder.textTempMin.setText(tempMinString + (char) 0x00B0 + " C");
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
