package com.example.a20220203_harshraj_nycschools.dependencyinjection.module;

import dagger.Module;

/**
 * This module will be used for all creating all dependencies which will be used accross app/
 */
@Module(includes = {ViewModelModule.class})
public abstract class AppModule {
}
