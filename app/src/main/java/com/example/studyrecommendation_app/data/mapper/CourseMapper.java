package com.example.studyrecommendation_app.data.mapper;

import java.util.ArrayList;
import java.util.List;

import com.example.studyrecommendation_app.data.model.CourseLocal;
import com.example.studyrecommendation_app.data.model.CoursePresenter;
import com.example.studyrecommendation_app.data.model.UniversityPresenter;

public class CourseMapper {

    public static List<CoursePresenter> mapLocalListToPresenters(List<CourseLocal> coursesLocal, List<UniversityPresenter> universitiesPresenter) {
        ArrayList<CoursePresenter> result = new ArrayList<>();

        for (int i = 0; i < coursesLocal.size(); ++i) {
            CoursePresenter presenter = mapLocalToPresenter(coursesLocal.get(i), universitiesPresenter.get(i));
            result.add(presenter);
        }

        return result;
    }

    public static CoursePresenter mapLocalToPresenter(CourseLocal courseLocal, UniversityPresenter universityPresenter) {
        CoursePresenter presenter = new CoursePresenter();
        presenter.setCourse(courseLocal.getCourse());
        presenter.setImageIdentifier(courseLocal.getImageIdentifier());
        presenter.setDescription(courseLocal.getDescription());
        presenter.setUniversityName(universityPresenter.getName());
        return presenter;
    }

}
