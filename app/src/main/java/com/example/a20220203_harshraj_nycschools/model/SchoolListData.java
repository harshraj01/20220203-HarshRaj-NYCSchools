package com.example.a20220203_harshraj_nycschools.model;

/**
 * This is model class which is used in the UI to display information.
 * This model only contains data which is to be used in UI.
 */
public class SchoolListData {

    private String fullName = "";
    private String dbn = "";

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDbn(String dbn) {
        this.dbn = dbn;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDbn() {
        return dbn;
    }
}
