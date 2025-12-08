package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private ArrayList<Integer> scores;

    private static int nextId = 1;

    public double calcAssignmentAvg() {
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
        Random random = new Random();

        for (int i = 0; i < scores.size(); i++) {
            int randomCategory = random.nextInt(11);
        }

    }
}
