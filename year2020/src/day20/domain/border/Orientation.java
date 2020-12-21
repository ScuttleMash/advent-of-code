package day20.domain.border;

import static day20.domain.border.Rotation.*;

public enum Orientation {

    TOP(0),
    RIGHT(3),
    BOTTOM(2),
    LEFT(1);

    private final int clockwiseStepsToReachTop;

    Orientation(int clockwiseStepsToReachTop) {
        this.clockwiseStepsToReachTop = clockwiseStepsToReachTop;
    }

    public Rotation rotationToFitWith(Orientation that) {
        int stepCount = ((that.clockwiseStepsToReachTop - this.clockwiseStepsToReachTop) + 6) % 4;

        if (stepCount == 0) {
            return DEGREES_0;
        } else if (stepCount == 1) {
            return DEGREES_90;
        } else if (stepCount == 2) {
            return DEGREES_180;
        } else if (stepCount == 3) {
            return DEGREES_270;
        } else {
            throw new RuntimeException("Value should always be within 4.");
        }
    }
}
