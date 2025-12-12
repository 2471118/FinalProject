package org.Tang;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import util.Util;

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

    /**
     * registers a student for a course
     * @param course the chosen course
     * @return the student registered
     */
    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            return false;
        }

        registeredCourses.add(course);
        course.registerStudent(this);
        return true;
    }

    /**
     * drops a student from a course
     * @param course the chosen course
     * @return the student dropped
     */
    public boolean dropCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            return false;
        }

        registeredCourses.remove(course);
        course.getRegisteredStudents().remove(this);
        return true;
    }

    /**
     * reformats the string into a simpler version
     * @return the simplified string
     */
    public String toSimplifiedString() {
        return String.format("%s - %s (%s)", studentId, studentName, department);
    }

    public Student(String studentName, Gender gender, Address address, Department department) {
            this.studentId = String.format("%06d", nextId++);
            this.studentName = Util.toTitleCase(studentName);
            this.gender = gender;
            this.address = address;
            this.department = department;
            this.registeredCourses = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender=" + gender +
                ", address=" + address +
                ", department=" + department +
                ", registeredCourses=" + registeredCourses +
                '}';
    }
}
