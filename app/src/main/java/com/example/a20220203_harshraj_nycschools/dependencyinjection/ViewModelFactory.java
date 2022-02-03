package com.example.a20220203_harshraj_nycschools.dependencyinjection;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/**
 * {@link ViewModelFactory} is responsible for connecting Dagger with {@link ViewModel}.
 * It obtains ViewModel from Dagger's provider
 */
@Singleton
public class ViewModelFactory implements ViewModelProvider.Factory {

    private final Map<Class<? extends ViewModel>, Provider<ViewModel>> mCreators;

    /**
     * In the traditional way of injecting View Models into ViewModelFactory it violates Liskov Substitution principle.
     * Hence we are injecting providers of respective ViewModels.
     * @param creators
     */
    @Inject
    public ViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> creators) {
        this.mCreators = creators;
    }

    /**
     * Creates a new instance of the given {@code Class}.
     * @param modelClass a {@code Class} whose instance is requested
     * @param <T> {@link ViewModel}.
     * @return a newly created ViewModel
     */
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        Provider<? extends ViewModel> creator = mCreators.get(modelClass);
        if (creator == null) {
            for (Map.Entry<Class<? extends ViewModel>, Provider<ViewModel>> entry : mCreators.entrySet()) {
                if (modelClass.isAssignableFrom(entry.getKey())) {
                    creator = entry.getValue();
                    break;
                }
            }
        }
        if (creator == null) {
            throw new IllegalArgumentException("unknown model class " + modelClass);
        }
        try {
            return (T) creator.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
