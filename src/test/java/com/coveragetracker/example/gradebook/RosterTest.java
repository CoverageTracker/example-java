package com.coveragetracker.example.gradebook;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RosterTest {

    private Student studentWithGpa(String name, Grade grade) {
        Student student = new Student(name);
        student.addResult(3.0, grade, GpaPoints.Modifier.NONE);
        return student;
    }

    @Test
    void averageGpaAndTopStudentAcrossTheRoster() {
        Roster roster = new Roster(List.of(
                studentWithGpa("Ada", Grade.A),
                studentWithGpa("Grace", Grade.B),
                studentWithGpa("Katherine", Grade.C)));

        assertEquals(3.0, roster.averageGpa(), 1e-9);
        assertEquals("Ada", roster.topStudent().name());
        assertEquals(0, roster.honorRollCount());
    }

    @Test
    void medianGpaForAnOddSizedRoster() {
        Roster roster = new Roster(List.of(
                studentWithGpa("Ada", Grade.A),
                studentWithGpa("Grace", Grade.B),
                studentWithGpa("Katherine", Grade.C)));

        assertEquals(3.0, roster.medianGpa(), 1e-9);
    }

    @Test
    void medianGpaForAnEvenSizedRosterAveragesTheMiddleTwo() {
        Roster roster = new Roster(List.of(
                studentWithGpa("Ada", Grade.A),
                studentWithGpa("Grace", Grade.B),
                studentWithGpa("Katherine", Grade.C),
                studentWithGpa("Dorothy", Grade.D)));

        assertEquals(2.5, roster.medianGpa(), 1e-9);
    }
}
