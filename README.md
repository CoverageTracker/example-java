# example-java

[![coverage badge](https://img.shields.io/endpoint?url=https%3A%2F%2Fdemo.coveragetracker.dev%2Fapi%2Fbadge%2FCoverageTracker%2Fexample-java%2Fcoverage.json)](https://demo.coveragetracker.dev/CoverageTracker/example-java?metric=coverage)
[![complexity badge](https://img.shields.io/endpoint?url=https%3A%2F%2Fdemo.coveragetracker.dev%2Fapi%2Fbadge%2FCoverageTracker%2Fexample-java%2Fcomplexity.json)](https://demo.coveragetracker.dev/CoverageTracker/example-java?metric=complexity)

A small, idiomatic Java gradebook library used as the Java reference example
for [Coverage Tracker](https://coveragetracker.dev). It exists to give the
Java row in the
[coverage report generation guide](https://coveragetracker.dev/docs/generating-coverage-reports)
a live, working reference, and to populate the
[demo dashboard](https://demo.coveragetracker.dev) with real trend data.

**This is a demo/marketing repo, not a test suite for Coverage Tracker
itself.**

## What's here

- `Grade.java` — maps a numeric score to a letter grade band (A–F).
- `GpaPoints.java` — converts a letter grade, with an optional +/- modifier,
  to 4.0-scale GPA points.
- `Student.java` — a transcript of credit-hour-weighted course results, GPA,
  and honor-roll status.
- `Roster.java` — aggregate stats (average/median GPA, top student, honor
  roll count) across a group of students.
- Each class has unit tests, but some real branches are deliberately left
  untested — the `D` grade band and out-of-range score checks in `Grade`,
  the descriptive `label()` method, the `MINUS` GPA modifier, and the
  invalid-input guard clauses in `Student`/`Roster` — landing at ~85% line /
  ~71% branch coverage, so `branch_coverage < line_coverage` is visible on
  the dashboard.
- `.github/workflows/coverage.yml` — runs tests under
  [JaCoCo](https://www.jacoco.org/jacoco/) via Maven, then reports to the
  demo instance via the `coverage-tracker` reporting Action. No separate
  complexity step is needed — JaCoCo's `COMPLEXITY` counter gives cyclomatic
  complexity for free.

## Running locally

```sh
mvn test jacoco:report   # writes target/site/jacoco/jacoco.xml
```
