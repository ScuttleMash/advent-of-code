package day18.domain.operands;

import day18.domain.Equation;

public class ComplexOperand extends Operand {

    private final Equation equation;

    public ComplexOperand(Equation equation) {
        this.equation = equation;
    }

    @Override
    public long getValue() {
        return equation.solve();
    }

    @Override
    public String toString() {
        return equation.toString();
    }
}
