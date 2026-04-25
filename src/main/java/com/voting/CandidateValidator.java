package com.voting;

public class CandidateValidator {

    public static boolean isValidCandidate(int id) {
        return AddCandidate.getCandidates().containsKey(id);
    }

    public static boolean hasCandidates() {
        return !AddCandidate.getCandidates().isEmpty();
    }

    // 🔹 New: Get candidate name safely
    public static String getCandidateName(int id) {
        if (!isValidCandidate(id)) {
            return "Invalid Candidate";
        }
        return AddCandidate.getCandidates().get(id);
    }
}