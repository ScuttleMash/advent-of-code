package day18.domain.operations;

import day18.domain.operands.Operand;

public class Multiplication extends Operation {

    @Override
    long calculate(Operand left, Operand right) {
        return left.getValue() * right.getValue();
    }

    @Override
    public String toString() {
        return "*";
    }
}
