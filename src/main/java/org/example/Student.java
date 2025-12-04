package org.example;

import java.util.ArrayList;
import java.util.List;


public class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.course = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
        course.getStudent().add(this);
    }
}
