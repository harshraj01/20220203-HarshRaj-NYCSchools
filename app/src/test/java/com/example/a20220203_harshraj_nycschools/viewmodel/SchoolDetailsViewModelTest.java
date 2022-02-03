package com.example.a20220203_harshraj_nycschools.viewmodel;


import com.example.a20220203_harshraj_nycschools.api.usecase.SchoolUseCase;
import com.example.a20220203_harshraj_nycschools.repositories.CurrentSelectedSchool;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Unit tests for SchoolDetailsViewModel
 */
@RunWith(MockitoJUnitRunner.class)
public class SchoolDetailsViewModelTest {

    @Mock
    private CurrentSelectedSchool currentSelectedSchool;
    @Mock
    private SchoolUseCase schoolUseCase;

    private SchoolDetailsViewModel schoolDetailsViewModel;

    @Before
    public void setUp() {
        schoolDetailsViewModel = new SchoolDetailsViewModel(currentSelectedSchool, schoolUseCase);
    }

    @Test
    public void testGetSchoolDetailsApi() {
        schoolDetailsViewModel.getSchoolDetailsAPI();
        Mockito.verify(schoolUseCase).getSchoolDetails(schoolDetailsViewModel);
    }

    @Test
    public void testGetIsLoading() {
        Assertions.assertThat(schoolDetailsViewModel.getIsLoading()).isNotNull();
    }
}
