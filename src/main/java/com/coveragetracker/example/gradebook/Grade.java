package com.coveragetracker.example.gradebook;

/** Letter grades on a standard five-band numeric scale. */
public enum Grade {
    A(90.0),
    B(80.0),
    C(70.0),
    D(60.0),
    F(0.0);

    private final double minScore;

    Grade(double minScore) {
        this.minScore = minScore;
    }

    public double minScore() {
        return minScore;
    }

    /** A short human-readable label for the grade band, e.g. for report headers. */
    public String label() {
        return switch (this) {
            case A -> "Excellent";
            case B -> "Good";
            case C -> "Satisfactory";
            case D -> "Passing";
            case F -> "Failing";
        };
    }

    /** Maps a numeric score in [0, 100] to a letter grade. */
    public static Grade fromScore(double score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("score must be between 0 and 100: " + score);
        }
        if (score >= A.minScore) {
            return A;
        } else if (score >= B.minScore) {
            return B;
        } else if (score >= C.minScore) {
            return C;
        } else if (score >= D.minScore) {
            return D;
        } else {
            return F;
        }
    }
}
