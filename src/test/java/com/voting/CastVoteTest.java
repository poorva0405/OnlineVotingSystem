package com.voting;

import static org.junit.Assert.*;
import org.junit.Test;

public class CastVoteTest {

    @Test
    public void testCastVoteSuccess() {
        AddCandidate.addCandidate(10, "John");
        assertTrue(CastVote.castVote(101, 10));
    }

    @Test
    public void testVoteTwice() {
        AddCandidate.addCandidate(11, "Emma");
        CastVote.castVote(102, 11);
        assertFalse(CastVote.castVote(102, 11));
    }
}
