package com.example.a20220203_harshraj_nycschools.api.response;

import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * API response body of school list response.
 * We can have all the property parsed here but we also parse only selected value like dbn/school_name.
 */
public class SchoolListResponse{

    @SerializedName("dbn")
    @Expose
    @Nullable
    private String dbn;
    @SerializedName("school_name")
    @Expose
    @Nullable
    private String fullName;

    public SchoolListResponse(@Nullable String dbn, @Nullable String fullName) {
        this.dbn = dbn;
        this.fullName = fullName;
    }

    @Nullable
    public String getFullName() {
        return fullName;
    }

    @Nullable
    public String getDbn() {
        return dbn;
    }
}
