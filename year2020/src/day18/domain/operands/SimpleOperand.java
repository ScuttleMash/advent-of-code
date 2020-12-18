package day18.domain.operands;

public class SimpleOperand extends Operand {

    private final long value;

    public SimpleOperand(long value) {
        this.value = value;
    }

    @Override
    public long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
