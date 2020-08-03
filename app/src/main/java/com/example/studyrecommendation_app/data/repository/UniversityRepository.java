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
import com.example.studyrecommendation_app.data.model.UniversityPresenter;

public class UniversityRepository {

    public List<UniversityPresenter> getUniversities() {
        String json = loadUniversitiesJson();
        return parseUniversitiesJson(json);
    }

    private String loadUniversitiesJson() {
        InputStream is;
        BufferedInputStream bis;

        try {
            is = App.getContext().getResources().openRawResource(R.raw.universities);
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

    private List<UniversityPresenter> parseUniversitiesJson(String json) {
        ArrayList<UniversityPresenter> result = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(json);
            int index = 0;

            while (jsonArray.length() > index) {
                JSONObject jsonObject = jsonArray.getJSONObject(index);
                String name = jsonObject.getString("name");
                UniversityPresenter presenter = new UniversityPresenter();
                presenter.setName(name);
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
