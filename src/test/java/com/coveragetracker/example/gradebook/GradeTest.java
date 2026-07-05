package com.coveragetracker.example.gradebook;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GradeTest {

    @Test
    void topOfScaleIsA() {
        assertEquals(Grade.A, Grade.fromScore(95.0));
        assertEquals(Grade.A, Grade.fromScore(90.0));
    }

    @Test
    void midScaleIsB() {
        assertEquals(Grade.B, Grade.fromScore(85.0));
    }

    @Test
    void lowerMidScaleIsC() {
        assertEquals(Grade.C, Grade.fromScore(75.0));
    }

    @Test
    void bottomOfScaleIsF() {
        assertEquals(Grade.F, Grade.fromScore(50.0));
    }
}
