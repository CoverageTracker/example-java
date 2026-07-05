package com.coveragetracker.example.gradebook;

import java.util.Comparator;
import java.util.List;

/** Aggregate statistics across a roster of students. */
public final class Roster {

    private final List<Student> students;

    public Roster(List<Student> students) {
        if (students.isEmpty()) {
            throw new IllegalArgumentException("roster must contain at least one student");
        }
        this.students = students;
    }

    public double averageGpa() {
        return students.stream().mapToDouble(Student::gpa).average().orElse(0.0);
    }

    public Student topStudent() {
        return students.stream()
                .max(Comparator.comparingDouble(Student::gpa))
                .orElseThrow();
    }

    public long honorRollCount() {
        return students.stream().filter(Student::honorRoll).count();
    }

    /** Median GPA; averages the two middle values for an even-sized roster. */
    public double medianGpa() {
        List<Double> sorted = students.stream()
                .map(Student::gpa)
                .sorted()
                .toList();
        int n = sorted.size();
        int mid = n / 2;
        if (n % 2 == 0) {
            return (sorted.get(mid - 1) + sorted.get(mid)) / 2.0;
        }
        return sorted.get(mid);
    }
}
