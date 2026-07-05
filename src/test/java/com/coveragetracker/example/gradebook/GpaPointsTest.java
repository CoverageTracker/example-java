package com.coveragetracker.example.gradebook;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GpaPointsTest {

    @Test
    void plainGradeHasNoModifierAdjustment() {
        assertEquals(3.0, GpaPoints.points(Grade.B, GpaPoints.Modifier.NONE));
    }

    @Test
    void plusModifierBoostsPointsButCapsAtFourPointO() {
        assertEquals(4.0, GpaPoints.points(Grade.A, GpaPoints.Modifier.PLUS));
        assertEquals(2.3, GpaPoints.points(Grade.C, GpaPoints.Modifier.PLUS), 1e-9);
    }

    @Test
    void fIgnoresModifier() {
        assertEquals(0.0, GpaPoints.points(Grade.F, GpaPoints.Modifier.PLUS));
    }
}
