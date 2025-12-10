package org.Tang;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@EqualsAndHashCode
@Getter
@Setter
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;

    private static int nextId = 1;

    public enum Gender {
        MALE, FEMALE
    }

    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            return false;
        }
        return true;
    }

    public Student(String studentName, Gender gender, Address address, Department department) {
            this.studentId = String.format("%06d", nextId);
            this.studentName = studentName;
            this.gender = gender;
            this.address = address;
            this.department = department;
            this.registeredCourses = new ArrayList<>();
    }
}
