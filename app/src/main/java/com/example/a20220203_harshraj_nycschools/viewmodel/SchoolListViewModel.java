package com.example.a20220203_harshraj_nycschools.viewmodel;

import android.view.View;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a20220203_harshraj_nycschools.api.base.ApiResponseCallback;
import com.example.a20220203_harshraj_nycschools.api.response.SchoolDetailsResponse;
import com.example.a20220203_harshraj_nycschools.api.response.SchoolListResponse;
import com.example.a20220203_harshraj_nycschools.api.usecase.SchoolUseCase;
import com.example.a20220203_harshraj_nycschools.model.SchoolListData;
import com.example.a20220203_harshraj_nycschools.repositories.CurrentSelectedSchool;
import com.example.a20220203_harshraj_nycschools.ui.recylerview.adapter.SchoolListAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * This class is ViewModel for showing list of schools.
 *
 */
public class SchoolListViewModel extends ViewModel implements ApiResponseCallback {

    private SchoolListAdapter schoolListAdapter;
    public MutableLiveData<Boolean> mIsLoading;
    public MutableLiveData<Boolean> onRecyclerItemClicked;
    private SchoolUseCase schoolUseCase;

    List<SchoolListData> schoolListData = new ArrayList<>();

    private CurrentSelectedSchool currentSelectedSchool;

    @Inject
    public SchoolListViewModel(CurrentSelectedSchool currentSelectedSchool, SchoolUseCase schoolUseCase) {
        this.currentSelectedSchool = currentSelectedSchool;
        this.schoolUseCase = schoolUseCase;
        this.onRecyclerItemClicked = new MutableLiveData<>();
        this.mIsLoading = new MutableLiveData<>();
    }

    public void getSchoolList() {
        schoolUseCase.getSchoolList(this);
    }

    /**
     * This onSuccess method is called when API is successful.
     * @param value
     */
    @Override
    public void onSuccess(Object value) {
        List<SchoolDetailsResponse> schoolListResponses = (List<SchoolDetailsResponse>)value;
        for(Object schoolListResponse : schoolListResponses) {
            SchoolListData schoolListData = new SchoolListData();
            schoolListData.setFullName(((SchoolListResponse)schoolListResponse).getFullName());
            schoolListData.setDbn( ((SchoolListResponse)schoolListResponse).getDbn());
            this.schoolListData.add(schoolListData);
        }
         schoolListAdapter = new SchoolListAdapter(schoolListData, this);

        mIsLoading.setValue(false);

    }

    /**
     * This live data is subscribed in UI to dismiss spinner and show the recycler view list.
     * @return
     */
    public MutableLiveData<Boolean> getIsLoading() {
        return mIsLoading;
    }

    public SchoolListAdapter getManageAccountListAdapter() {
        return schoolListAdapter;
    }

    public MutableLiveData<Boolean> getOnRecyclerItemClicked() {
        return onRecyclerItemClicked;
    }

    /**
     * This method is called when API gives error.
     * Over here we can show error screen/dialog/toast based on requirement.
     * @param error
     */
    @Override
    public void onError(String error) {
        mIsLoading.setValue(false);
    }

    /**
     * This method is called from layout when each row is clicked.
     * @param view
     */
    public void onItemClick(View view) {
        int position = (Integer) view.getTag();
        if (schoolListData == null || position >= schoolListData.size()) return;
            SchoolListData schoolListData = this.schoolListData.get(position);
            setCurrentSchool(schoolListData);
            onRecyclerItemClicked.setValue(false);
    }

    /**
     * Set the current selected school in repository.
     * @param schoolListData
     */
    private void setCurrentSchool(SchoolListData schoolListData) {
        currentSelectedSchool.setCurrentSchoolListData(schoolListData);
    }
}
