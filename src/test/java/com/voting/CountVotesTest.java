package com.voting;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CountVotesTest {

    @Before
    public void setUp() {
        AddCandidate.getCandidates().clear();
        CastVote.getVotes().clear();
        CastVote.getVoters().clear();
    }

    @Test
    public void testDeclareWinnerSingleCandidate() {
        AddCandidate.addCandidate(1, "Alice");

        CastVote.castVote(101, 1);
        CastVote.castVote(102, 1);

        List<String> winners = CountVotes.declareWinner();

        assertEquals(1, winners.size());
        assertEquals("Alice", winners.get(0));
    }

    @Test
    public void testDeclareWinnerMultipleCandidates() {
        AddCandidate.addCandidate(2, "Bob");
        AddCandidate.addCandidate(3, "Charlie");

        CastVote.castVote(201, 2);
        CastVote.castVote(202, 2);
        CastVote.castVote(203, 3);

        List<String> winners = CountVotes.declareWinner();

        assertEquals(1, winners.size());
        assertEquals("Bob", winners.get(0));
    }

    @Test
    public void testNoVotesCast() {
        List<String> winners = CountVotes.declareWinner();

        assertEquals(1, winners.size());
        assertEquals("No votes cast", winners.get(0));
    }

    @Test
    public void testTieScenario() {
        AddCandidate.addCandidate(4, "David");
        AddCandidate.addCandidate(5, "Emma");

        CastVote.castVote(301, 4);
        CastVote.castVote(302, 5);

        List<String> winners = CountVotes.declareWinner();

        assertEquals(2, winners.size());
        assertTrue(winners.contains("David"));
        assertTrue(winners.contains("Emma"));
    }
}