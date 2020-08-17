package com.example.studyrecommendation_app.ui.third;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import com.example.studyrecommendation_app.data.model.UniversityPresenter;
import com.example.studyrecommendation_app.data.repository.UniversityRepository;

public class UniversityViewModel extends ViewModel {
    MutableLiveData<List<UniversityPresenter>> universities = new MutableLiveData<>();
    private UniversityRepository mUniversityRepository = new UniversityRepository();


    void loadUniversities() {
        List<UniversityPresenter> universities = mUniversityRepository.getUniversities();
        this.universities.setValue(universities);
    }

}
