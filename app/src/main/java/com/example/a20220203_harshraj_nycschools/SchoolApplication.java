package com.example.a20220203_harshraj_nycschools;

import com.example.a20220203_harshraj_nycschools.dependencyinjection.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;


/**
 * Application class whicjh extends DaggerApplication for dependency injection.
 * Here Dagger component is created application graph.
 */
public class SchoolApplication extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    /**
     * Override applicationInjector method to create dagger componenet.
     * @return
     */
    @Override
    protected AndroidInjector<? extends SchoolApplication> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }
}
