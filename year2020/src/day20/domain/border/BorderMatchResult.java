package day20.domain.border;

import day20.domain.Image;

public class BorderMatchResult {

    public static final BorderMatchResult NONE = new BorderMatchResult(false);

    private final boolean match;
    private final Image image;
    private final Rotation rotation;
    private final boolean flipped;

    private BorderMatchResult(boolean match) {
        this.match = match;
        this.image = null;
        this.rotation = null;
        this.flipped = false;
    }

    public BorderMatchResult(Image image, Rotation rotation, boolean flipped) {
        this.match = true;
        this.image = image;
        this.rotation = rotation;
        this.flipped = flipped;
    }

    public boolean isMatch() {
        return match;
    }

    public Image getImage() {
        return image;
    }

    public Rotation getRotation() {
        return rotation;
    }

    public boolean isFlipped() {
        return flipped;
    }
}
