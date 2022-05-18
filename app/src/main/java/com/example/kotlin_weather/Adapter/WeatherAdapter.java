package com.example.kotlin_weather.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kotlin_weather.Model.List;
import com.example.kotlin_weather.R;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {
    ArrayList<List> list_weather;
    Context context;

    public WeatherAdapter(ArrayList<List> list_weather, Context context) {
        this.list_weather = list_weather;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_weather, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        List list = list_weather.get(position);
        //TODO: them logic convert UTC -> date.
        DateFormat formatterUTC = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        formatterUTC.setTimeZone(TimeZone.getTimeZone("UTC")); // UTC timezone
        holder.text_Time.setText(formatterUTC.format(list.getDt()));
        holder.text_Temp.setText(String.valueOf(list.getMain().getTemp()));
        holder.text_TempMax.setText(String.valueOf(list.getMain().getTempMax()));
        holder.text_TempMin.setText(String.valueOf(list.getMain().getTempMin()));
    }

    @Override
    public int getItemCount() {
        if (list_weather == null) {
            return 0;
        } else

            return list_weather.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text_Time, text_Temp, text_TempMin, text_TempMax;
        ImageView image_Icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text_Time = itemView.findViewById(R.id.text_Time);
            text_Temp = itemView.findViewById(R.id.text_Temp);
            text_TempMin = itemView.findViewById(R.id.text_TempMin);
            text_TempMax = itemView.findViewById(R.id.text_TempMax);
            image_Icon = itemView.findViewById(R.id.image_Icon);
        }
    }
}
