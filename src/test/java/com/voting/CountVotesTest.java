package com.voting;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CountVotesTest {

    @Before
    public void setUp() {
        // Clear all static data before each test
        AddCandidate.getCandidates().clear();
        CastVote.getVotes().clear();
        CastVote.getVoters().clear();
    }

    @Test
    public void testDeclareWinnerSingleCandidate() {
        AddCandidate.addCandidate(1, "Alice");

        CastVote.castVote(101, 1);
        CastVote.castVote(102, 1);

        String winner = CountVotes.declareWinner();

        assertEquals("Alice", winner);
    }

    @Test
    public void testDeclareWinnerMultipleCandidates() {
        AddCandidate.addCandidate(2, "Bob");
        AddCandidate.addCandidate(3, "Charlie");

        CastVote.castVote(201, 2);
        CastVote.castVote(202, 2);
        CastVote.castVote(203, 3);

        String winner = CountVotes.declareWinner();

        assertEquals("Bob", winner);
    }

    @Test
    public void testNoVotesCast() {
        String winner = CountVotes.declareWinner();

        assertEquals("No votes cast", winner);
    }

    @Test
    public void testTieScenario() {
        AddCandidate.addCandidate(4, "David");
        AddCandidate.addCandidate(5, "Emma");

        CastVote.castVote(301, 4);
        CastVote.castVote(302, 5);

        String winner = CountVotes.declareWinner();

        // In case of tie, stream().max() returns one of them (not guaranteed order)
        assertTrue(winner.equals("David") || winner.equals("Emma"));
    }
}