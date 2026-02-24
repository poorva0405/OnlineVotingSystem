package com.voting;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CastVoteTest {

    @Before
    public void setUp() {
        // Clear all static data before each test
        AddCandidate.getCandidates().clear();
        CastVote.getVoters().clear();      // assuming you have this
        CountVotes.getVotes().clear();     // assuming you have this
    }

    @Test
    public void testCastVoteSuccess() {
        AddCandidate.addCandidate(10, "John");

        boolean result = CastVote.castVote(101, 10);

        assertTrue(result);
    }

    @Test
    public void testVoteTwiceBySameVoter() {
        AddCandidate.addCandidate(11, "Emma");

        CastVote.castVote(102, 11);
        boolean secondVote = CastVote.castVote(102, 11);

        assertFalse(secondVote);
    }

    @Test
    public void testVoteForNonExistingCandidate() {
        boolean result = CastVote.castVote(103, 999);

        assertFalse(result);
    }

    @Test
    public void testMultipleVotersSameCandidate() {
        AddCandidate.addCandidate(12, "David");

        boolean vote1 = CastVote.castVote(201, 12);
        boolean vote2 = CastVote.castVote(202, 12);

        assertTrue(vote1);
        assertTrue(vote2);
    }

    @Test
    public void testDifferentVotersDifferentCandidates() {
        AddCandidate.addCandidate(13, "Alice");
        AddCandidate.addCandidate(14, "Bob");

        boolean vote1 = CastVote.castVote(301, 13);
        boolean vote2 = CastVote.castVote(302, 14);

        assertTrue(vote1);
        assertTrue(vote2);
    }
}