package com.example.teacher_moderatorrating;

public class Student
{
    private int id;
    private String email,password;

    public Student( String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Student() {
    }

//    public int getId() {
//        return id;
//    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
