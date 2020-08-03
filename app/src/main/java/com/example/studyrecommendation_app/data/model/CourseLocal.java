package com.example.studyrecommendation_app.data.model;

public class CourseLocal {
    private String course;
    private String description;
    private String imageIdentifier;


    public String getImageIdentifier() { return imageIdentifier; }

    public String getCourse() {
        return course;
    }

    public String getDescription() {
        return description;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageIdentifier(String imageIdentifier) { this.imageIdentifier = imageIdentifier; }

}
