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

        public String toSimplifiedString() {
            String message = "Student{" +
                    "name=" + name + '\'' +
                    ", courses=";

            for (Course course : courses) {
                message += course.toSimplifiedString() + ",";
            }

            return message;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';

        for (Course course : courses) {
            message += course.toSimplifiedString() + ",";
        }

        return message;
    }
    }
}
