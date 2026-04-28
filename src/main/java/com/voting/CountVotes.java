package com.voting;

import java.util.*;

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

    
    public static List<String> declareWinner() {
        Map<Integer, Integer> votes = CastVote.getVotes();

        if (votes.isEmpty()) {
            return Collections.singletonList("No votes cast");
        }

        // Find max votes
        int maxVotes = Collections.max(votes.values());

        List<String> winners = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : votes.entrySet()) {
            if (entry.getValue() == maxVotes) {
                String candidateName = AddCandidate.getCandidates().get(entry.getKey());
                winners.add(candidateName);
            }
        }

        return winners;
    }
}