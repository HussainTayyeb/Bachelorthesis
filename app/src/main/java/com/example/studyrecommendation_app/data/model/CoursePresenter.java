package com.example.studyrecommendation_app.data.model;

public class CoursePresenter {
    private String imageIdentifier;
    private String course;
    private String description;
    private String universityName;


    public String getImageIdentifier() {
        return imageIdentifier;
    }

    public String getCourse() {
        return course;
    }

    public String getDescription() {
        return description;
    }

    public String getUniversityName() { return universityName; }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUniversityName(String universityName) { this.universityName = universityName; }

    public void setImageIdentifier(String imageIdentifier) { this.imageIdentifier = imageIdentifier; }

}