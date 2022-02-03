package com.example.a20220203_harshraj_nycschools.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.example.a20220203_harshraj_nycschools.R;
import com.example.a20220203_harshraj_nycschools.databinding.SchoolDetailsBinding;
import com.example.a20220203_harshraj_nycschools.ui.fragment.base.BaseFragment;
import com.example.a20220203_harshraj_nycschools.viewmodel.SchoolDetailsViewModel;

/**
 * This fragment which is used to show schools details which is fetched from API response.
 * This class only contains UI related code using databinding. It's corresponding ViewModel is
 * {@link SchoolDetailsViewModel}  which is using observable and live data to show data on UI.
 */
public class SchoolDetailsFragment extends BaseFragment {

    private SchoolDetailsBinding mViewDataBinding;
    private SchoolDetailsViewModel schoolDetailsViewModel;

    /**
     * Using DataBindingUtil to inflate and get the layout binding instance.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewDataBinding = DataBindingUtil.inflate(inflater, R.layout.school_details, container, false);
        View view = mViewDataBinding.getRoot();
        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        schoolDetailsViewModel = (SchoolDetailsViewModel) getViewModel(SchoolDetailsViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewDataBinding.setLifecycleOwner(this);
        mViewDataBinding.setSchoolDetailsViewModel(schoolDetailsViewModel);
        mViewDataBinding.progressView.setVisibility(View.VISIBLE);
        schoolDetailsViewModel.getSchoolDetailsAPI();
        subscribe();
    }

    /**
     * Subscribe to dismiss the progress view after the API response.
     */
    private void subscribe() {
        schoolDetailsViewModel.getIsLoading().observe(getViewLifecycleOwner(), aBoolean -> {
            if (null != aBoolean && !aBoolean) {
                mViewDataBinding.progressView.setVisibility(View.GONE);
            }
        });
    }
}
