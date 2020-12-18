package day18.domain.operands;

import day18.domain.Equation;
import day18.domain.solvers.Solver;

public class ComplexOperand extends Operand {

    private final Equation equation;
    private final Solver solver;

    public ComplexOperand(Equation equation, Solver solver) {
        this.equation = equation;
        this.solver = solver;
    }

    @Override
    public long getValue() {
        return equation.solve(solver);
    }

    @Override
    public String toString() {
        return equation.toString();
    }
}
