package day18.domain.operations;

import day18.domain.operands.Operand;

public abstract class Operation {

    public long perform(Operand left, Operand right) {
        return calculate(left, right);
    }

    abstract long calculate(Operand left, Operand right);
}
