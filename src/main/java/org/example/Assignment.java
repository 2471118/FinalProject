package org.example;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import util.Util;

import java.util.ArrayList;
import java.util.Random;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private ArrayList<Integer> scores;

    private static int nextId = 1;

    /**
     * calculates the average of assignments
     * @return the average of assignments
     */
    public double calcAssignmentAvg() {
        if (scores == null || scores.isEmpty()) {
            return 0;
        }

        double sum = 0;
        int count = 0;

        for (Integer score : scores) {
            if (score != null) {
                sum += score;
                count++;
            }
        }
        return count == 0 ? 0 : sum / count;
    }

    public void generateRandomScore() {
        if (scores == null) {
            scores = new ArrayList<>();
        }

        Random random = new Random();

        for (int i = 0; i < scores.size(); i++) {
            int range = random.nextInt(11);
            int score;
            if (range == 0) {
                score = random.nextInt(60);
            } else if (range <= 2) {
                score = 60 + random.nextInt(10);
            } else if (range <= 4) {
                score = 70 + random.nextInt(10);
            } else if (range <= 8) {
                score = 80 + random.nextInt(10);
            } else {
                score = 90 + random.nextInt(11);
            }
            scores.set(i, score);
        }
    }

    public Assignment(String assignmentName, double weight) {
        this.assignmentId = String.format("%02d", nextId++);
        this.assignmentName = Util.toTitleCase(assignmentName);
        this.weight = weight;
        this.scores = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Assignment [ID: " + assignmentId + ", Name: " + assignmentName + ", Weight: " + weight + "%]";
    }
}
