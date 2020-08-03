package com.example.studyrecommendation_app.data.repository;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.example.studyrecommendation_app.App;
import com.example.studyrecommendation_app.R;
import com.example.studyrecommendation_app.data.model.CourseLocal;

public class CourseRepository {

    public List<CourseLocal> getCourses() {
        String json = loadCoursesJson();
        return parseCoursesJson(json);
    }

    private String loadCoursesJson() {
        InputStream is;
        BufferedInputStream bis;

        try {
            is = App.getContext().getResources().openRawResource(R.raw.courses);
            bis = new BufferedInputStream(is);
            StringBuilder sb = new StringBuilder(bis.available());
            int count = 0;

            while ((count = bis.read()) != -1) {
                sb.append((char) count);
            }

            bis.close();
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    private List<CourseLocal> parseCoursesJson(String json) {
        ArrayList<CourseLocal> result = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(json);
            int index = 0;

            while (jsonArray.length() > index) {
                JSONObject jsonObject = jsonArray.getJSONObject(index);
                String course = jsonObject.getString("course");
                String description = jsonObject.getString("description");
                String imageIdentifier = jsonObject.getString("image_identifier");
                CourseLocal presenter = new CourseLocal();
                presenter.setCourse(course);
                presenter.setDescription(description);
                presenter.setImageIdentifier(imageIdentifier);
                result.add(presenter);
                ++index;
            }

            return result;
        } catch (JSONException e) {
            e.printStackTrace();
            return result;
        }

    }

}
