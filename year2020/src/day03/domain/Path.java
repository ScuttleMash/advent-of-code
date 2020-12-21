package day03.domain;

public class Path {

    private final int stepRight;
    private final int stepDown;

    public Path(int stepRight, int stepDown) {
        this.stepRight = stepRight;
        this.stepDown = stepDown;
    }

    public int getStepDown() {
        return stepDown;
    }

    public int getStepRight() {
        return stepRight;
    }
}
