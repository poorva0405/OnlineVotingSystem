package com.voting;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class AddCandidateTest {

    @Before
    public void setUp() {
        // Clear the static map before each test
        AddCandidate.getCandidates().clear();
    }

    @Test
    public void testAddCandidateSuccess() {
        boolean result = AddCandidate.addCandidate(1, "Alice");

        assertTrue(result);
        assertEquals("Alice", AddCandidate.getCandidates().get(1));
    }

    @Test
    public void testDuplicateCandidateId() {
        AddCandidate.addCandidate(2, "Bob");

        boolean result = AddCandidate.addCandidate(2, "Charlie");

        assertFalse(result);
        assertEquals("Bob", AddCandidate.getCandidates().get(2));
    }

    @Test
    public void testNullName() {
        boolean result = AddCandidate.addCandidate(3, null);

        assertFalse(result);
        assertFalse(AddCandidate.getCandidates().containsKey(3));
    }

    @Test
    public void testEmptyName() {
        boolean result = AddCandidate.addCandidate(4, "");

        assertFalse(result);
        assertFalse(AddCandidate.getCandidates().containsKey(4));
    }

    @Test
    public void testMultipleValidCandidates() {
        AddCandidate.addCandidate(5, "David");
        AddCandidate.addCandidate(6, "Emma");

        Map<Integer, String> candidates = AddCandidate.getCandidates();

        assertEquals(2, candidates.size());
        assertEquals("David", candidates.get(5));
        assertEquals("Emma", candidates.get(6));
    }
}