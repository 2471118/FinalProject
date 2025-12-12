package org.Tang;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import util.Util;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;

    private static int nextId;

    /**
     * Checks if the assignment weight is valid or not
     * @return whether the assignment weight is valid or not
     */
    public boolean isAssignmentWeightValid() {
        double sum = 0;
        for (Assignment assignment : assignments) {
            sum += assignment.getWeight();
        }
        return Math.abs(sum - 100) < 0.001;
    }

    /**
     * adds the student to this course
     * @param student the student to be registered to this course
     * @return the student registered in this course
     */
    public boolean registerStudent(Student student) {
        if (registeredStudents.contains(student)) {
            return false;
        }

        registeredStudents.add(student);
        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }

        return true;
    }

    /**
     * calculates the students' average
     * @return the students' average
     */
    public int[] calcStudentsAverage() {
        int[] averages = new int[registeredStudents.size()];

        for (int i = 0; i < registeredStudents.size(); i++) {
            double sum = 0;

            for (Assignment assignment : assignments) {
                Integer weight = assignment.getScores().get(i);
                if (weight != null)
                    sum += weight * assignment.getWeight() / 100;
            }
            averages[i] = (int) Math.round(sum);

        }
        return averages;
    }

    /**
     * add an assignment to the course
     * @param assignmentName the name of the assignment
     * @param weight the wight of the assignment
     * @return the course with the new assignment
     */
    public boolean addAssignment(String assignmentName, double weight) {
        Assignment assignment = new Assignment(assignmentName, weight);
        assignments.add(assignment);

        for (int i = 0; i < registeredStudents.size(); i++) {
            assignment.getScores().add(null);
        }
        return true;
    }

    public void generateScores() {
        for (Assignment assignment : assignments) {
            assignment.generateRandomScore();
        }
        calcStudentsAverage();
    }

    public void displayScores() {
        System.out.println("\nCourse: " + courseName + " (" + courseId + ")");

        if (registeredStudents.isEmpty() || assignments.isEmpty()) {
            System.out.println("No students or assignments to display.");
            return;
        }

        System.out.printf("%-20s", "");
        for (Assignment assignment : assignments) {
            System.out.printf("%15s", assignment.getAssignmentName());
        }
        System.out.printf("%15s%n", "Final Score");

        int[] averages = calcStudentsAverage();
        for (int i = 0; i < registeredStudents.size(); i++) {
            Student student = registeredStudents.get(i);
            System.out.printf("%-20s", student.getStudentName());

            for (Assignment assignment : assignments) {
                List<Integer> scores = assignment.getScores();

                if (i < scores.size() && scores.get(i) != null) {
                    System.out.printf("%15d", scores.get(i));
                } else {
                    System.out.printf("%15s", "N/A");
                }
            }

            System.out.printf("%15d%n", averages[i]);
        }

        System.out.printf("%-20s", "Average");
        for (Assignment assignment : assignments) {
            double avg = assignment.calcAssignmentAvg();
            System.out.printf("%15.1f", avg);
        }
        System.out.println();
    }

    /**
     * reformats the string into a simpler version
     * @return the simplified string
     */
    public String toSimplifiedString() {
        return courseId + " - " + courseName + " (" + credits + "cr, "
                + department.getDepartmentName() + ")";
    }

    public Course(String courseName, double credits, Department department) {
        this.courseId = String.format("C-%s-%02d", department.getDepartmentId(), nextId++);
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Course ID: " + courseId + "\n" +
                "Course Name: " + courseName + "\n" +
                "Credits: " + credits + "\n" +
                "Department: " + (department != null ? department.getDepartmentName() : "No Department") + "\n" +
                "Assignments:\n");

        for (Assignment assignment : assignments) {
            result.append("  - ").append(assignment).append("\n");
        }

        result.append("Registered Students:\n");
        for (Student student : registeredStudents) {
            result.append("  - ").append(student.toSimplifiedString()).append("\n");
        }

        result.append("Assignment Weight Valid: ").append(isAssignmentWeightValid()).append("\n");

        return result.toString();
    }
}
