package day03.domain;

public class Position {

    private final int fromLeft;
    private final int fromTop;

    public Position(int fromLeft, int fromTop) {
        this.fromLeft = fromLeft;
        this.fromTop = fromTop;
    }

    public int getFromLeft() {
        return fromLeft;
    }

    public int getFromTop() {
        return fromTop;
    }
}
