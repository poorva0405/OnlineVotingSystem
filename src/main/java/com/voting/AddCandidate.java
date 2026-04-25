package com.voting;

import java.util.*;

public class AddCandidate {

    private static Map<Integer, String> candidates = new HashMap<>();

    public static boolean addCandidate(int id, String name) {
        if (candidates.containsKey(id) || name == null || name.isEmpty()) {
            return false;
        }
        candidates.put(id, name);
        return true;
    }

    public static Map<Integer, String> getCandidates() {
        return candidates;
    }

    public static void displayCandidates() {

        if (candidates.isEmpty()) {
            System.out.println("No candidates available.");
            return;
        }

        for (Map.Entry<Integer, String> entry : candidates.entrySet()) {
            System.out.println("ID: " + entry.getKey() +
                            " | Name: " + entry.getValue());
        }
    }
    
    public static boolean candidateExists(int id) {
    return candidates.containsKey(id);
}

public static String getCandidateName(int id) {
    return candidates.getOrDefault(id, "Not Found");
}

public static int totalCandidates() {
    return candidates.size();
}
}
