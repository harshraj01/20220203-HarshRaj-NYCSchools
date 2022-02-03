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
 * Unit tests for SchoolListViewModel
 */
@RunWith(MockitoJUnitRunner.class)
public class SchoolListViewModelTest {

    @Mock
    private CurrentSelectedSchool currentSelectedSchool;
    @Mock
    private SchoolUseCase schoolUseCase;

    private SchoolListViewModel schoolListViewModel;

    @Before
    public void setUp() {
        schoolListViewModel = new SchoolListViewModel(currentSelectedSchool, schoolUseCase);
    }

    @Test
    public void testGetSchoolDetailsApi() {
        schoolListViewModel.getSchoolList();
        Mockito.verify(schoolUseCase).getSchoolList(schoolListViewModel);
    }

    @Test
    public void testGetIsLoading() {
        Assertions.assertThat(schoolListViewModel.getIsLoading()).isNotNull();
    }
}
