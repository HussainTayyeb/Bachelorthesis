/*

This class loads data from our DataSource (in this case the questions.json file)

 */


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
import com.example.studyrecommendation_app.data.QuestionPresenter;

public class QuestionRepository {

    public List<QuestionPresenter> getQuestions() {
        String json = loadQuestionsJson();
        return parseQuestionsJson(json);
    }
    // This method loads questions from the file res -> raw -> questions.json
    private String loadQuestionsJson() {
        InputStream is;
        BufferedInputStream bis;

        try {
            is = App.getContext().getResources().openRawResource(R.raw.questions);
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

    private List<QuestionPresenter> parseQuestionsJson(String json) {
        ArrayList<QuestionPresenter> result = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(json);
            int index = 0;

            while (jsonArray.length() > index) {
                JSONObject jsonObject = jsonArray.getJSONObject(index);
                String question = jsonObject.getString("question");
                Object imageField = jsonObject.get("image");
                String imageIdentifier;
                if (jsonObject.has("image") && !jsonObject.isNull("image")) {
                    imageIdentifier = jsonObject.getString("image");
                } else imageIdentifier = null;
                QuestionPresenter presenter = new QuestionPresenter();
                presenter.setQuestion(question);
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