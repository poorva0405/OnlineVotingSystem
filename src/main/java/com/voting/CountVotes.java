package com.voting;

import java.util.Map;

public class CountVotes {

    public static void displayResults() {
        Map<Integer, Integer> votes = CastVote.getVotes();

        if (votes.isEmpty()) {
            System.out.println("No votes cast yet.");
            return;
        }

        for (Map.Entry<Integer, Integer> entry : votes.entrySet()) {
            System.out.println(
                AddCandidate.getCandidates().get(entry.getKey())
                + " : " + entry.getValue() + " votes"
            );
        }
    }

    public static String declareWinner() {
        return CastVote.getVotes()
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(e -> AddCandidate.getCandidates().get(e.getKey()))
                .orElse("No votes cast");
    }
}


