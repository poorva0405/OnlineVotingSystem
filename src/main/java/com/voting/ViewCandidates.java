package com.voting;

import java.util.Map;

public class ViewCandidates {

    public static void displayCandidates() {

        Map<Integer, String> candidates = AddCandidate.getCandidates();

        if (candidates.isEmpty()) {
            System.out.println("No candidates available.");
            return;
        }

        System.out.println("\n--- Candidate List ---");

        for (Map.Entry<Integer, String> entry : candidates.entrySet()) {
            System.out.println("ID: " + entry.getKey() +
                               " | Name: " + entry.getValue());
        }
    }
}