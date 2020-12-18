package day18.domain;

import day18.domain.solvers.Solver;

public class Equation {

    private final String raw;

    public Equation(String raw) {
        this.raw = raw;
    }

    public String getEquationString() {
        return raw;
    }

    public long solve(Solver solver) {
        return solver.solve(this);
    }

    @Override
    public String toString() {
        return "Equation: " + raw;
    }
}
