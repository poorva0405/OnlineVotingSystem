package com.voting;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class CastVoteTest {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        // Capture console output
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Clear all static data before each test
        AddCandidate.getCandidates().clear();
        CastVote.getVotes().clear();
        CastVote.getVoters().clear();
    }

    @Test
public void testCastVoteWithViewSuccess() {
    AddCandidate.addCandidate(10, "John");

    boolean result = CastVote.castVoteWithView(101, 10);

    assertTrue(result);
    assertEquals(1, (int) CastVote.getVotes().get(10));
}

    @Test
    public void testVoteTwiceBySameVoterWithView() {
        AddCandidate.addCandidate(11, "Emma");

        CastVote.castVoteWithView(102, 11);
        boolean secondVote = CastVote.castVoteWithView(102, 11);

        assertFalse(secondVote);
        assertEquals(1, (int) CastVote.getVotes().get(11));
    }

    @Test
    public void testVoteForNonExistingCandidateWithView() {
        boolean result = CastVote.castVoteWithView(103, 999);

        assertFalse(result);
    }

    @Test
    public void testMultipleVotersSameCandidateWithView() {
        AddCandidate.addCandidate(12, "David");

        CastVote.castVoteWithView(201, 12);
        CastVote.castVoteWithView(202, 12);

        assertEquals(2, (int) CastVote.getVotes().get(12));
    }

    @Test
    public void testDifferentCandidatesVotesWithView() {
        AddCandidate.addCandidate(13, "Alice");
        AddCandidate.addCandidate(14, "Bob");

        CastVote.castVoteWithView(301, 13);
        CastVote.castVoteWithView(302, 14);

        assertEquals(1, (int) CastVote.getVotes().get(13));
        assertEquals(1, (int) CastVote.getVotes().get(14));
    }
}