package com.example.pc_3.retrofitexample;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by PC-3 on 09/10/2017.
 */

public class BaseClient {


    private static OkHttpClient provideClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    private static Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .client(provideClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Api provideApiService() {
        return retrofit().create(Api.class);
    }
}