package com.voting;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CastVote {

    private static Set<Integer> voters = new HashSet<>();
    private static Map<Integer, Integer> votes = new HashMap<>();

    // 🔹 New method: View candidates before voting
    public static boolean castVoteWithView(int voterId, int candidateId) {

        // Step 1: Show candidates
        System.out.println("\nPlease choose from the following candidates:");
        AddCandidate.displayCandidates();

        // Step 2: Perform voting
        return castVote(voterId, candidateId);
    }

    // Existing method (unchanged)
    public static boolean castVote(int voterId, int candidateId) {
        if (voters.contains(voterId) ||
            !CandidateValidator.isValidCandidate(candidateId)) {
            return false;
        }
        voters.add(voterId);
        votes.put(candidateId, votes.getOrDefault(candidateId, 0) + 1);
        return true;
    }

    public static Map<Integer, Integer> getVotes() {
        return votes;
    }

    public static Set<Integer> getVoters() {
        return voters;
    }
}