/*

A ViewModel in general holds the data of a View (Activity/Fragment)
or handles user events (click, long click, navigate).

The only event that this ViewModel handles is when the user navigates
to the Activity and we need to load the Questions from our 'questions.json' file.

 */

package com.example.studyrecommendation_app.first;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import com.example.studyrecommendation_app.data.QuestionPresenter;
import com.example.studyrecommendation_app.data.repository.QuestionRepository;

public class QuestionViewModel extends ViewModel {
    MutableLiveData<List<QuestionPresenter>> questions = new MutableLiveData<>();
    private QuestionRepository questionRepository = new QuestionRepository();


    void loadQuestions() {
        questions.setValue(questionRepository.getQuestions());
    }

}
