package day16.solution.domain;

public class Range {

    private final int leftBorder;
    private final int rightBorder;

    public Range(int leftBorder, int rightBorder) {
        this.leftBorder = leftBorder;
        this.rightBorder = rightBorder;
    }

    public boolean contains(int value) {
        return leftBorder <= value && value <= rightBorder;
    }

    @Override
    public String toString() {
        return leftBorder + "-" + rightBorder;
    }
}
