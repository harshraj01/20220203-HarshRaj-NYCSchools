package com.example.a20220203_harshraj_nycschools.dependencyinjection.module;


import com.example.a20220203_harshraj_nycschools.ui.fragment.SchoolDetailsFragment;
import com.example.a20220203_harshraj_nycschools.ui.fragment.SchoolListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * This module is used to create all fragments which app is having.
 */
@Module
public abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract SchoolListFragment provideSchoolListFragmentFragment();

    @ContributesAndroidInjector
    abstract SchoolDetailsFragment provideSchoolDetailsFragmentFragment();
}
