package com.example.a20220203_harshraj_nycschools.dependencyinjection.module;


import com.example.a20220203_harshraj_nycschools.ui.activity.SchoolActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Acivity module which contains all activities.
 */
@Module
public abstract class ActivityModule {
    @ContributesAndroidInjector(modules = {FragmentModule.class})
    abstract SchoolActivity bindSchoolActivity();
}
