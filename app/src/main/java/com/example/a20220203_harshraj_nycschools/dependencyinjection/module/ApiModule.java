package com.example.a20220203_harshraj_nycschools.dependencyinjection.module;


import com.example.a20220203_harshraj_nycschools.api.usecase.implementation.SchoolsRetrofitApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * API module which create network dependent instances to provide acccross app.
 * Over here we add add all network dependent instances.
 */
@Module
public class ApiModule {

    private String BASE_URL = "https://data.cityofnewyork.us";
    @Provides
    @Singleton
    SchoolsRetrofitApi providesVLTransfersRetrofitApi() {
        return createRetrofit(BASE_URL).create(SchoolsRetrofitApi.class);
    }

    private Retrofit createRetrofit(String baseUrl){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }
}
