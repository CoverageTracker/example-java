package com.coveragetracker.example.gradebook;

/** Converts a letter grade, with an optional +/- modifier, to 4.0-scale GPA points. */
public final class GpaPoints {

    private GpaPoints() {
    }

    public enum Modifier {
        PLUS, MINUS, NONE
    }

    public static double points(Grade grade, Modifier modifier) {
        double base = switch (grade) {
            case A -> 4.0;
            case B -> 3.0;
            case C -> 2.0;
            case D -> 1.0;
            case F -> 0.0;
        };
        if (grade == Grade.F) {
            return base;
        }
        return switch (modifier) {
            case PLUS -> Math.min(4.0, base + 0.3);
            case MINUS -> Math.max(0.0, base - 0.3);
            case NONE -> base;
        };
    }
}
