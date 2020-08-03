package com.example.studyrecommendation_app.ui.second;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import com.example.studyrecommendation_app.data.mapper.CourseMapper;
import com.example.studyrecommendation_app.data.model.CourseLocal;
import com.example.studyrecommendation_app.data.model.CoursePresenter;
import com.example.studyrecommendation_app.data.model.UniversityPresenter;
import com.example.studyrecommendation_app.data.repository.CourseRepository;
import com.example.studyrecommendation_app.data.repository.UniversityRepository;

public class CoursesViewModel extends ViewModel {
    MutableLiveData<List<CoursePresenter>> courses = new MutableLiveData<>();
    private CourseRepository mCourseRepository = new CourseRepository();
    private UniversityRepository mUniversityRepository = new UniversityRepository();


    void loadCourses() {
        List<CourseLocal> courses = mCourseRepository.getCourses();
        List<UniversityPresenter> universities = mUniversityRepository.getUniversities();
        List<CoursePresenter> presenters =  CourseMapper.mapLocalListToPresenters(courses, universities);
        this.courses.setValue(presenters);
    }

}