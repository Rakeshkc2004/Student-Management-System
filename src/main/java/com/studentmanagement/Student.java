package com.studentmanagement;

public class Student {
    private int id;
    private String name;
    private int age;
    private String course;
    private String email;

    public Student(String name,int age, String course, String email) {


        this.name = name;
        this.age = age;
        this.course = course;
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
