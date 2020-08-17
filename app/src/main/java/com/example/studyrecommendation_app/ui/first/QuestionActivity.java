/*
This class is responsible for showing the questions.
 */


package com.example.studyrecommendation_app.ui.first;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import com.example.studyrecommendation_app.R;
import com.example.studyrecommendation_app.data.model.QuestionPresenter;
import com.example.studyrecommendation_app.ui.base.BaseActivity;
import com.example.studyrecommendation_app.ui.second.CoursesActivity;
import com.example.swipe_stack_layout.SwipeStack;


public class QuestionActivity extends BaseActivity implements View.OnClickListener, SwipeStack.SwipeStackListener {
    private SwipeStack mSwipeStack;
    private FloatingActionButton mFabCorrect, mFabWrong;
    private QuestionViewModel mQuestionViewModel;
    private QuestionStackAdapter mQuestionStackAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        mQuestionViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);
        initViews();
        setupStack();
        setupFloatingActionButtons();
        observeQuestions();
        mQuestionViewModel.loadQuestions();
    }

    private void initViews() {
        mSwipeStack = findViewById(R.id.swipeStackLayout_main_questionStack);
        mFabCorrect = findViewById(R.id.floatingActionButton_main_correct);
        mFabWrong = findViewById(R.id.floatingActionButton_main_wrong);
    }

    private void observeQuestions() {
        mQuestionViewModel.questions.observe(this, new Observer<List<QuestionPresenter>>() {
            @Override
            public void onChanged(List<QuestionPresenter> questionPresenters) {
                mQuestionStackAdapter.addItems(questionPresenters);
            }
        });
    }

    private void setupStack() {
        mQuestionStackAdapter = new QuestionStackAdapter();
        mSwipeStack.setAdapter(mQuestionStackAdapter);
        mSwipeStack.setListener(this);
    }

    private void setupFloatingActionButtons() {
        mFabCorrect.setOnClickListener(this);
        mFabWrong.setOnClickListener(this);
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

    @Override
    public void onViewSwipedToLeft(int position) { }

    @Override
    public void onViewSwipedToRight(int position) { }

    @Override
    public void onStackEmpty() {
        navigateToCoursesActivity();
    }

    private void navigateToCoursesActivity() {
        Intent intent = new Intent(this, CoursesActivity.class);
        startActivity(intent);
        finish();
    }

}