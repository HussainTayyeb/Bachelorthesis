package com.example.studyrecommendation_app.ui.second;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import com.example.studyrecommendation_app.R;
import com.example.studyrecommendation_app.data.model.CourseLocal;
import com.example.studyrecommendation_app.data.model.CoursePresenter;
import com.example.studyrecommendation_app.ui.base.BaseActivity;
import com.example.swipe_stack_layout.SwipeStack;

public class CoursesActivity extends BaseActivity implements View.OnClickListener {
    private SwipeStack mSwipeStack;
    private FloatingActionButton mFabCorrect, mFabWrong;
    private CoursesViewModel mCoursesViewModel;
    private CourseStackAdapter mCourseStackAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        mCoursesViewModel = new ViewModelProvider(this).get(CoursesViewModel.class);
        initViews();
        setupStack();
        setupFloatingActionButtons();
        observeCourses();
        mCoursesViewModel.loadCourses();
    }

    private void initViews() {
        mSwipeStack = findViewById(R.id.swipeStackLayout_main_questionStack);
        mFabCorrect = findViewById(R.id.floatingActionButton_main_correct);
        mFabWrong = findViewById(R.id.floatingActionButton_main_wrong);
    }

    private void setupStack() {
        mCourseStackAdapter = new CourseStackAdapter();
        mSwipeStack.setAdapter(mCourseStackAdapter);
    }

    private void setupFloatingActionButtons() {
        mFabCorrect.setOnClickListener(this);
        mFabWrong.setOnClickListener(this);
    }

    private void observeCourses() {
        mCoursesViewModel.courses.observe(this, new Observer<List<CoursePresenter>>() {
            @Override
            public void onChanged(List<CoursePresenter> coursePresenters) {
                mCourseStackAdapter.addItems(coursePresenters);
            }
        });
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.floatingActionButton_main_correct:
                mSwipeStack.swipeTopViewToRight();
                break;
            case R.id.floatingActionButton_main_wrong:
                mSwipeStack.swipeTopViewToLeft();
                break;
        }

    }

}
