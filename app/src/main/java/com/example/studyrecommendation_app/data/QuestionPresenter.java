/*

This class holds the questions data, i.e. question text and image (if available)
It also provides some getter and setter methods
to set or get the value of a filed (question, image).

 */

package com.example.studyrecommendation_app.data;

public class QuestionPresenter {
    private String question;
    private String imageIdentifier;


    public String getQuestion() {
        return question;
    }

    public String getImageIdentifier() {
        return imageIdentifier;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setImageIdentifier(String imageIdentifier) {
        this.imageIdentifier = imageIdentifier;
    }

}