/*
This class is responsible for showing the questions.
 */


package com.example.studyrecommendation_app.first;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import com.example.studyrecommendation_app.R;
import com.example.studyrecommendation_app.data.QuestionPresenter;
import com.example.swipe_stack_layout.SwipeStack;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener {
    private SwipeStack mSwipeStack;
    private FloatingActionButton fabCorrect, fabWrong;
    private QuestionViewModel mQuestionViewModel;
    private QuestionStackAdapter mQuestionStackAdapter;

    //part of the lifecycle from a AndroidActivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWindows();  // responsible for showing the notification bar at the top
        setContentView(R.layout.activity_main);
        mQuestionViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);
        initViews();
        setupStack();
        setupFloatingActionButtons();
        observeQuestions();
        mQuestionViewModel.loadQuestions();
    }

    private void initWindows() {
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
    }

    private void initViews() {
        mSwipeStack = findViewById(R.id.swipeStackLayout_main_questionStack);
        fabCorrect = findViewById(R.id.floatingActionButton_main_correct);
        fabWrong = findViewById(R.id.floatingActionButton_main_wrong);
    }
    // responsible for observing changes in the QuestionViewModel   // counts the items inside the questions.json
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
    }

    //setting up the Buttons (tick - Yes, x - No)
    private void setupFloatingActionButtons() {
        fabCorrect.setOnClickListener(this);
        fabWrong.setOnClickListener(this);
    }
    //If buttons gets clicked the card shows the animation (x - left tick - right)
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
