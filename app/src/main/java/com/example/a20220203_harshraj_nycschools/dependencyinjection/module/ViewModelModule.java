package com.example.a20220203_harshraj_nycschools.dependencyinjection.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.a20220203_harshraj_nycschools.dependencyinjection.ViewModelFactory;
import com.example.a20220203_harshraj_nycschools.viewmodel.SchoolDetailsViewModel;
import com.example.a20220203_harshraj_nycschools.viewmodel.SchoolListViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * This module will be used to provide ViewModel which is used accross the app.
 */
@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(SchoolListViewModel.class)
    protected abstract ViewModel schoolListViewModel(SchoolListViewModel schoolListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(SchoolDetailsViewModel.class)
    protected abstract ViewModel schoolDetailsViewModel(SchoolDetailsViewModel schoolDetailsViewModel);

}
