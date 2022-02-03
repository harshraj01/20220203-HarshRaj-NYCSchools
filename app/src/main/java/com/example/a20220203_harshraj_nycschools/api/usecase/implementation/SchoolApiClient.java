package com.example.a20220203_harshraj_nycschools.api.usecase.implementation;


import androidx.annotation.NonNull;


import com.example.a20220203_harshraj_nycschools.api.base.ApiClientCallback;
import com.example.a20220203_harshraj_nycschools.api.base.ApiResponseCallback;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * This is the class which directly interact with retrofit API and enqueue and get the callback.
 */
@Singleton
public class SchoolApiClient {

    private SchoolsRetrofitApi schoolsRetrofitApi;

    @Inject
    public SchoolApiClient(SchoolsRetrofitApi schoolsRetrofitApi) {
        this.schoolsRetrofitApi = schoolsRetrofitApi;
    }

    public void getSchoolList(@NonNull final ApiResponseCallback<Object> callback) {
        schoolsRetrofitApi.getSchoolList()
                    .enqueue(getCallback(callback));
        }

    public void getSchoolDetails(@NonNull final ApiResponseCallback<Object> callback) {
        schoolsRetrofitApi.getSchoolDetails()
                .enqueue(getCallback(callback));
    }

    private ApiClientCallback getCallback(@NonNull final ApiResponseCallback<Object> callback) {
        return new ApiClientCallback(new ApiResponseCallback<Object>() {
            @Override
            public void onSuccess(Object value) {
                callback.onSuccess(value);
            }
            @Override
            public void onError(String error) {
                callback.onError(error);
            }
        });
    }

}
