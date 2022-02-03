package com.example.a20220203_harshraj_nycschools.api.response;

import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * API response body of School details.
 */
public class SchoolDetailsResponse {

    @SerializedName("dbn")
    @Expose
    @Nullable
    private String dbn;
    @SerializedName("school_name")
    @Expose
    @Nullable
    private String schoolName;
    @SerializedName("num_of_sat_test_takers")
    @Expose
    @Nullable
    private String satTaker;
    @SerializedName("sat_critical_reading_avg_score")
    @Expose
    @Nullable
    private String satCriticalReadingAvgScore;
    @SerializedName("sat_math_avg_score")
    @Expose
    @Nullable
    private String satMathAvgScore;
    @SerializedName("sat_writing_avg_score")
    @Expose
    @Nullable
    private String satWritingAvgScore;


    public SchoolDetailsResponse(@Nullable String dbn, @Nullable String schoolName, @Nullable String satTaker, @Nullable String satCriticalReadingAvgScore, @Nullable String satMathAvgScore, @Nullable String satWritingAvgScore) {
        this.dbn = dbn;
        this.schoolName = schoolName;
        this.satTaker = satTaker;
        this.satCriticalReadingAvgScore = satCriticalReadingAvgScore;
        this.satMathAvgScore = satMathAvgScore;
        this.satWritingAvgScore = satWritingAvgScore;
    }

    @Nullable
    public String getDbn() {
        return dbn;
    }

    @Nullable
    public String getSchoolName() {
        return schoolName;
    }

    @Nullable
    public String getSatTaker() {
        return satTaker;
    }

    @Nullable
    public String getSatCriticalReadingAvgScore() {
        return satCriticalReadingAvgScore;
    }

    @Nullable
    public String getSatMathAvgScore() {
        return satMathAvgScore;
    }

    @Nullable
    public String getSatWritingAvgScore() {
        return satWritingAvgScore;
    }
}
