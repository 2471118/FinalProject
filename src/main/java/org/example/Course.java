package org.example;

import java.util.ArrayList;
import java.util.List;

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

    public boolean addAssignment(String assignmentName, double weight) {
        Assignment assignment = new Assignment(assignmentName, weight);
        assignments.add(assignment);

        for (int i = 0; i < registeredStudents.size(); i++) {
            assignment.addScore(null);
        }
        return true;
    }
}
