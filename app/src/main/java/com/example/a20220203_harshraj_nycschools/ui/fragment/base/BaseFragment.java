package com.example.a20220203_harshraj_nycschools.ui.fragment.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.example.a20220203_harshraj_nycschools.dependencyinjection.ViewModelFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * Base fragment which contains common method to get ViewModel.
 * This class can be used to have all common methods which is common across all fragments.
 */
public abstract class BaseFragment extends DaggerFragment {

    @Inject
    ViewModelFactory viewModelFactory;

    protected ViewModel getViewModel(Class viewModel) {
        return getViewModelProvider(getActivity(), viewModelFactory).get(viewModel);
    }

    /**
     * Get ViewModel from ViewModelProvider of architecture componenets.
     * @param owner
     * @param factory
     * @return
     */
    private ViewModelProvider getViewModelProvider(@NonNull ViewModelStoreOwner owner, @Nullable ViewModelFactory factory) {
        if(factory == null) {
            return new ViewModelProvider(owner);
        }
        return new ViewModelProvider(owner, factory);
    }
}
