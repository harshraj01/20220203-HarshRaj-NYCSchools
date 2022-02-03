package com.example.a20220203_harshraj_nycschools.repositories;


import com.example.a20220203_harshraj_nycschools.model.SchoolListData;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * This is repositories which is used to save information of currently selected school from list.
 * This repositories can be used across the app to know information about currently selected school.
 */
@Singleton
public class CurrentSelectedSchool {

    private SchoolListData currentSchoolListData = null;

    @Inject
    public CurrentSelectedSchool() {
    }

    public SchoolListData getCurrentSchoolListData() {
        return currentSchoolListData;
    }

    public void setCurrentSchoolListData(SchoolListData currentSchoolListData) {
        this.currentSchoolListData = currentSchoolListData;
    }

}
