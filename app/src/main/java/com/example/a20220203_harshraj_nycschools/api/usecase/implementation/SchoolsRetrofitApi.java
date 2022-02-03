package com.example.a20220203_harshraj_nycschools.api.usecase.implementation;

import com.example.a20220203_harshraj_nycschools.api.response.SchoolDetailsResponse;
import com.example.a20220203_harshraj_nycschools.api.response.SchoolListResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Retrofit API which call the actual API.
 * Base URL is present in {@link com.example.a20220203_harshraj_nycschools.dependencyinjection.module.ApiModule}
 * where retrofit instance is created.
 */
public interface SchoolsRetrofitApi {

    @Headers("Content-Type: application/json")
    @GET("/resource/s3k6-pzi2.json")
    Call<List<SchoolListResponse>> getSchoolList();

    @Headers("Content-Type: application/json")
    @GET("/resource/f9bf-2cp4.json")
    Call<List<SchoolDetailsResponse>> getSchoolDetails();
}
