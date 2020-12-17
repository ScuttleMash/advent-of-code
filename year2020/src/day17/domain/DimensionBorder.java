package day17.domain;

public class DimensionBorder {

    private final int dimension;
    private final int min;
    private final int max;

    public DimensionBorder(int dimension, int min, int max) {
        this.dimension = dimension;
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    @Override
    public String toString() {
        return "Borders for dimension " + (dimension + 1) + " are [" + min + "-" + max + "].";
    }
}
