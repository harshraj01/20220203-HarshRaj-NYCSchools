package com.example.a20220203_harshraj_nycschools.viewmodel;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a20220203_harshraj_nycschools.api.base.ApiResponseCallback;
import com.example.a20220203_harshraj_nycschools.api.response.SchoolDetailsResponse;
import com.example.a20220203_harshraj_nycschools.api.usecase.SchoolUseCase;
import com.example.a20220203_harshraj_nycschools.repositories.CurrentSelectedSchool;

import java.util.List;

import javax.inject.Inject;

/**
 * This is the ViewModel class to show school details.
 * Using observable as well as live data to demonstrate how to show data on UI once we get the API response.
 */
public class SchoolDetailsViewModel extends ViewModel implements ApiResponseCallback {

    public ObservableField<String> schoolDetailsNameInfo;
  //  public ObservableField<String> satTestTakersDetailsInfo;
    public MutableLiveData<String> schoolDetailsSATScoreLiveData;
    private CurrentSelectedSchool currentSelectedSchool;
    private SchoolUseCase schoolUseCase;
    private MutableLiveData<Boolean> mIsLoading;

    @Inject
    public SchoolDetailsViewModel(CurrentSelectedSchool currentSelectedSchool, SchoolUseCase schoolUseCase) {
        this.currentSelectedSchool = currentSelectedSchool;
        this.schoolUseCase = schoolUseCase;
        schoolDetailsNameInfo = new ObservableField<>();
        //satTestTakersDetailsInfo = new ObservableField<>();
        schoolDetailsSATScoreLiveData = new MutableLiveData<>();
        this.mIsLoading = new MutableLiveData<>();
    }

    /**
     * Calls school details API.
     */
    public void getSchoolDetailsAPI() {
        schoolUseCase.getSchoolDetails(this);
    }

    /**
     * Through this method is live data is observed.
     * @return
     */
    public MutableLiveData<Boolean> getIsLoading() {
        return mIsLoading;
    }

    /**
     * This onSuccess method is called when API is successful.
     * @param value
     */
    @Override
    public void onSuccess(Object value) {
        mIsLoading.setValue(false);
        List<SchoolDetailsResponse> schoolDetailsResponses = (List<SchoolDetailsResponse>)value;
        for(Object schoolDetailsResponse : schoolDetailsResponses) {
            if(currentSelectedSchool.getCurrentSchoolListData().getDbn()
                    .equalsIgnoreCase(((SchoolDetailsResponse)schoolDetailsResponse).getDbn())) {
                schoolDetailsNameInfo.set(((SchoolDetailsResponse) schoolDetailsResponse).getSchoolName());
               // satTestTakersDetailsInfo.set(((SchoolDetailsResponse) schoolDetailsResponse).getSatTaker());
               schoolDetailsSATScoreLiveData.setValue(((SchoolDetailsResponse) schoolDetailsResponse).getSatTaker());
            }
        }

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


}
