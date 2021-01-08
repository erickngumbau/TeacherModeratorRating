package com.example.teacher_moderatorrating;

public class Teacher
{
    private String name;
    private String school;
    private String description;
    private String url;

    public Teacher(String name, String school, String description, String url) {
        this.name = name;
        this.school = school;
        this.description = description;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
