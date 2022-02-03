package com.example.a20220203_harshraj_nycschools.dependencyinjection;

import com.example.a20220203_harshraj_nycschools.SchoolApplication;
import com.example.a20220203_harshraj_nycschools.dependencyinjection.module.ActivityModule;
import com.example.a20220203_harshraj_nycschools.dependencyinjection.module.ApiModule;
import com.example.a20220203_harshraj_nycschools.dependencyinjection.module.AppModule;
import com.example.a20220203_harshraj_nycschools.dependencyinjection.module.FragmentModule;
import com.example.a20220203_harshraj_nycschools.dependencyinjection.module.ViewModelModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * This is the dagger component class which is used to create application dependency graph.
 */
@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        ActivityModule.class,
        FragmentModule.class,
        ViewModelModule.class,
        ApiModule.class
})
public interface AppComponent extends AndroidInjector<SchoolApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<SchoolApplication> {
    }
}
