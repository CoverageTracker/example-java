package com.coveragetracker.example.gradebook;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentTest {

    @Test
    void gpaIsZeroWithNoCourses() {
        Student student = new Student("Ada");
        assertEquals(0.0, student.gpa());
        assertEquals(0, student.courseCount());
    }

    @Test
    void gpaIsCreditHourWeightedAverage() {
        Student student = new Student("Grace");
        student.addResult(3.0, Grade.A, GpaPoints.Modifier.NONE);
        student.addResult(3.0, Grade.B, GpaPoints.Modifier.NONE);
        assertEquals(2, student.courseCount());
        assertEquals(3.5, student.gpa(), 1e-9);
    }

    @Test
    void honorRollRequiresEnoughCreditsAndAHighGpa() {
        Student honorRoll = new Student("Katherine");
        honorRoll.addResult(4.0, Grade.A, GpaPoints.Modifier.NONE);
        honorRoll.addResult(4.0, Grade.A, GpaPoints.Modifier.NONE);
        honorRoll.addResult(4.0, Grade.A, GpaPoints.Modifier.NONE);
        assertTrue(honorRoll.honorRoll());

        Student tooFewCredits = new Student("Dorothy");
        tooFewCredits.addResult(3.0, Grade.A, GpaPoints.Modifier.NONE);
        assertFalse(tooFewCredits.honorRoll());
    }
}
