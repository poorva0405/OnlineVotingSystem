package com.voting;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CastVoteTest {
    

    @Before
    public void setUp() {
        // Clear all static data before each test
        AddCandidate.getCandidates().clear();
        CastVote.getVotes().clear();
        CastVote.getVoters().clear();   // Add this method in CastVote
    }

    @Test
    public void testCastVoteSuccess() {
        AddCandidate.addCandidate(10, "John");

        boolean result = CastVote.castVote(101, 10);

        assertTrue(result);
        assertEquals(1, (int) CastVote.getVotes().get(10));
    }

    @Test
    public void testVoteTwiceBySameVoter() {
        AddCandidate.addCandidate(11, "Emma");

        CastVote.castVote(102, 11);
        boolean secondVote = CastVote.castVote(102, 11);

        assertFalse(secondVote);
        assertEquals(1, (int) CastVote.getVotes().get(11));
    }

    @Test
    public void testVoteForNonExistingCandidate() {
        boolean result = CastVote.castVote(103, 999);

        assertFalse(result);
    }

    @Test
    public void testMultipleVotersSameCandidate() {
        AddCandidate.addCandidate(12, "David");

        CastVote.castVote(201, 12);
        CastVote.castVote(202, 12);

        assertEquals(2, (int) CastVote.getVotes().get(12));
    }

    @Test
    public void testDifferentCandidatesVotes() {
        AddCandidate.addCandidate(13, "Alice");
        AddCandidate.addCandidate(14, "Bob");

        CastVote.castVote(301, 13);
        CastVote.castVote(302, 14);

        assertEquals(1, (int) CastVote.getVotes().get(13));
        assertEquals(1, (int) CastVote.getVotes().get(14));
    }
}