package com.voting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class CandidateValidatorTest {

    @Before
    public void setUp() {
        AddCandidate.getCandidates().clear();
    }

    @Test
    public void testIsValidCandidate_True() {
        AddCandidate.addCandidate(1, "Alice");
        assertTrue(CandidateValidator.isValidCandidate(1));
    }

    @Test
    public void testIsValidCandidate_False() {
        assertFalse(CandidateValidator.isValidCandidate(99));
    }

    @Test
    public void testHasCandidates() {
        assertFalse(CandidateValidator.hasCandidates());

        AddCandidate.addCandidate(2, "Bob");
        assertTrue(CandidateValidator.hasCandidates());
    }

    @Test
    public void testGetCandidateName_Valid() {
        AddCandidate.addCandidate(3, "Charlie");
        assertEquals("Charlie", CandidateValidator.getCandidateName(3));
    }

    @Test
    public void testGetCandidateName_Invalid() {
        assertEquals("Invalid Candidate", CandidateValidator.getCandidateName(100));
    }
}