package com.example.kotlin_weather.RetrofitApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit=null;
    private static final String URL="http://api.openweathermap.org/";
    public static Retrofit getIntance()
    {
        if (retrofit==null)
        {
            retrofit=new Retrofit.Builder()
                .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                .build();
        }
        return retrofit;
    }
}