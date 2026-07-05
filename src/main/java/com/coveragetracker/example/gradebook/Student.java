package com.coveragetracker.example.gradebook;

import java.util.ArrayList;
import java.util.List;

/** A student's transcript: a list of credit-hour-weighted course results. */
public final class Student {

    private final String name;
    private final List<CourseResult> results = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public void addResult(double creditHours, Grade grade, GpaPoints.Modifier modifier) {
        if (creditHours <= 0) {
            throw new IllegalArgumentException("creditHours must be positive: " + creditHours);
        }
        results.add(new CourseResult(creditHours, grade, modifier));
    }

    public int courseCount() {
        return results.size();
    }

    /** Credit-hour-weighted GPA across all recorded courses. */
    public double gpa() {
        if (results.isEmpty()) {
            return 0.0;
        }
        double totalPoints = 0.0;
        double totalCredits = 0.0;
        for (CourseResult result : results) {
            totalPoints += GpaPoints.points(result.grade(), result.modifier()) * result.creditHours();
            totalCredits += result.creditHours();
        }
        return totalPoints / totalCredits;
    }

    /** Honor roll requires at least 12 credit hours and a 3.5+ GPA. */
    public boolean honorRoll() {
        double totalCredits = results.stream().mapToDouble(CourseResult::creditHours).sum();
        return totalCredits >= 12.0 && gpa() >= 3.5;
    }

    private record CourseResult(double creditHours, Grade grade, GpaPoints.Modifier modifier) {
    }
}
