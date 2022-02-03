package com.example.a20220203_harshraj_nycschools.api.usecase;

import androidx.annotation.NonNull;

import com.example.a20220203_harshraj_nycschools.api.base.ApiResponseCallback;
import com.example.a20220203_harshraj_nycschools.api.usecase.implementation.SchoolApiClient;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * School API usecase. Likewise we can have different usecase class based on different feature in the app.
 */
@Singleton
public class SchoolUseCase {

    private SchoolApiClient schoolApiClient;

    @Inject
    public SchoolUseCase(SchoolApiClient schoolApiClient) {
        this.schoolApiClient = schoolApiClient;
    }

    public void getSchoolList(@NonNull ApiResponseCallback apiResponseCallback) {
        try {
            schoolApiClient.getSchoolList(apiResponseCallback);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    public void getSchoolDetails(@NonNull ApiResponseCallback apiResponseCallback) {
        try {
            schoolApiClient.getSchoolDetails(apiResponseCallback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
