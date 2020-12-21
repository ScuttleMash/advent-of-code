package day20.domain.border;

import day20.domain.Image;

import java.util.List;
import java.util.function.Function;

import static day20.domain.border.BorderMatchResult.NONE;

public abstract class Border {

    private final Image parent;
    private final String value;

    public Border(Image parent, Function<String, String> extractor) {
        this.parent = parent;
        this.value = extractor.apply(parent.getContent());
    }

    public abstract Orientation getOrientation();

    public BorderMatchResult findMatchingBorders(List<Border> those) {
        return those.stream().map(this::findMatchingBorders).filter(BorderMatchResult::isMatch).findAny().orElse(NONE);
    }

    private BorderMatchResult findMatchingBorders(Border that) {
        if (this.parent.equals(that.parent)) {
            return NONE;
        }

        if (this.value.equals(that.value)) {
            Rotation rotation = this.getOrientation().rotationToFitWith(that.getOrientation());
            return new BorderMatchResult(that.parent, rotation, true);
        } else if (this.value.equals(that.getFlippedValue())) {
            Rotation rotation = this.getOrientation().rotationToFitWith(that.getOrientation());
            return new BorderMatchResult(that.parent, rotation, false);
        }

        return NONE;
    }

    private String getFlippedValue() {
        return new StringBuilder(value).reverse().toString();
    }

}
