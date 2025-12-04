package org.example;

import java.util.ArrayList;

public class Course {
    private String name;
    private List<Student> student;

    public Course(String name) {
        this.name = name;
        this.student = new ArrayList<>();
    }

    public String toSimplifiedString() {

    }

    @Override
    public String toString() {
        String message = "Course{" +
                "name='" + name + '\'' +
                ', students=';


    }
}
