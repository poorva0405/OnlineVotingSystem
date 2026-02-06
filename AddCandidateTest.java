package com.voting;

import static org.junit.Assert.*;
import org.junit.Test;

public class AddCandidateTest {

    @Test
    public void testAddCandidateSuccess() {
        assertTrue(AddCandidate.addCandidate(1, "Alice"));
    }

    @Test
    public void testDuplicateCandidate() {
        AddCandidate.addCandidate(2, "Bob");
        assertFalse(AddCandidate.addCandidate(2, "Bob"));
    }
}
