package com.example.studyrecommendation_app.ui.third;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.example.studyrecommendation_app.R;
import com.example.studyrecommendation_app.data.model.UniversityPresenter;
import com.example.studyrecommendation_app.ui.base.BaseActivity;

public class UniversityActivity extends BaseActivity {
    private UniversityViewModel mUniversityViewModel;
    private RecyclerView recyclerViewUniversities;
    private UniversityAdapter mAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university);
        mUniversityViewModel = new ViewModelProvider(this).get(UniversityViewModel.class);
        initViews();
        setupList();
        observeUniversities();
        mUniversityViewModel.loadUniversities();
    }

    private void initViews() {
        recyclerViewUniversities = findViewById(R.id.recyclerView_university_universities);
    }

    private void setupList() {
        recyclerViewUniversities.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewUniversities.setHasFixedSize(true);
        recyclerViewUniversities.addItemDecoration(new UniversityItemDecoration());
        mAdapter = new UniversityAdapter();
        recyclerViewUniversities.setAdapter(mAdapter);
    }

    private void observeUniversities() {
        mUniversityViewModel.universities.observe(this, new Observer<List<UniversityPresenter>>() {
            @Override
            public void onChanged(List<UniversityPresenter> universityPresenters) {
                mAdapter.addItems(universityPresenters);
            }
        });
    }

}
