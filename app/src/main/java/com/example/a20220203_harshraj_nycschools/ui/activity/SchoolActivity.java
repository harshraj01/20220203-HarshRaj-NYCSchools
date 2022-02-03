package com.example.a20220203_harshraj_nycschools.ui.activity;

import android.os.Bundle;

import com.example.a20220203_harshraj_nycschools.R;
import com.example.a20220203_harshraj_nycschools.ui.fragment.SchoolListFragment;

import dagger.android.support.DaggerAppCompatActivity;

/**
 * This activity the launcher activity which is shown once the app is launched.
 * This activity will attach {@link SchoolListFragment}   to show the list of schools.
 */
public class SchoolActivity extends DaggerAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view, SchoolListFragment.class, null)
                    .commit();
        }

    }
}