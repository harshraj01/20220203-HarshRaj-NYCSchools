package com.example.a20220203_harshraj_nycschools.model;

import androidx.databinding.ObservableField;

/**
 * This is model class which is used in the UI to display information.
 * This model only contains data which is to be used in UI.
 */
public class SchoolListModel {
    public final ObservableField<String> fullname = new ObservableField<>();

    public SchoolListModel(String fullname){
        this.fullname.set(fullname);
    }

}
