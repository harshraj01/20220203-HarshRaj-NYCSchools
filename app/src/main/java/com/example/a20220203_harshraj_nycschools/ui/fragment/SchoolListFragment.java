package com.example.a20220203_harshraj_nycschools.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;

import com.example.a20220203_harshraj_nycschools.R;
import com.example.a20220203_harshraj_nycschools.databinding.SchoolListBinding;
import com.example.a20220203_harshraj_nycschools.ui.fragment.base.BaseFragment;
import com.example.a20220203_harshraj_nycschools.ui.recylerview.adapter.SchoolListAdapter;
import com.example.a20220203_harshraj_nycschools.viewmodel.SchoolListViewModel;

import java.util.Objects;

public class SchoolListFragment extends BaseFragment {

    private SchoolListViewModel schoolListViewModel;
    private SchoolListBinding mViewDataBinding;

    /**
     * Using DataBindingUtil to inflate and get the layout binding instance.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewDataBinding = DataBindingUtil.inflate(inflater, R.layout.school_list, container, false);
        View view = mViewDataBinding.getRoot();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        schoolListViewModel = (SchoolListViewModel) getViewModel(SchoolListViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewDataBinding.setLifecycleOwner(this);
        mViewDataBinding.progressView.setVisibility(View.VISIBLE);
        schoolListViewModel.getSchoolList();
        subscribe();
    }

    /**
     * Subscribe to dismiss the progress view after the API response.
     * Also subscribe to show school list in recycler view after the successful API response.
     */
    private void subscribe() {
        schoolListViewModel.getIsLoading().observe(getViewLifecycleOwner(), aBoolean -> {
            if (null != aBoolean && !aBoolean) {
                mViewDataBinding.progressView.setVisibility(View.GONE);
                setRecyclerView(schoolListViewModel.getManageAccountListAdapter());
            }
        });

        schoolListViewModel.getOnRecyclerItemClicked().observe(getViewLifecycleOwner(), aBoolean -> {
            if (null != aBoolean && !aBoolean) {
                showSchoolDetails();
            }
        });
    }

    private void setRecyclerView(SchoolListAdapter manageAccountListAdapter) {
        mViewDataBinding.recyclerView.setVisibility(View.VISIBLE);
        mViewDataBinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(Objects.requireNonNull(ContextCompat.getDrawable(requireContext(), R.drawable.divider)));
        mViewDataBinding.recyclerView.addItemDecoration(dividerItemDecoration);
        mViewDataBinding.recyclerView.setAdapter(manageAccountListAdapter);
    }

    /**
     * Launch another fragment to show school details based on school selected from list.
     */
    private void showSchoolDetails() {
        getActivity().getSupportFragmentManager().beginTransaction().addToBackStack("SchoolDetailsFragment").
                add(R.id.fragment_container_view, new SchoolDetailsFragment())
                .commit();
    }
}
