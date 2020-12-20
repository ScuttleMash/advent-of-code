package day20.domain;

import java.util.Objects;

public class Image {

    private final int tileId;
    private final ReversableString top;
    private final ReversableString right;
    private final ReversableString bottom;
    private final ReversableString left;

    public Image(int tileId, String top, String right, String bottom, String left) {
        this.tileId = tileId;
        this.top = new ReversableString(top);
        this.right = new ReversableString(right);
        this.bottom = new ReversableString(bottom);
        this.left = new ReversableString(left);
    }

    public int getTileId() {
        return tileId;
    }

    public boolean hasMatch(Image that) {
        if (this.equals(that)) {
            return false;
        }

        if (this.top.asIs().equals(that.top.asIs())) {
            return true;
        } else if (this.top.asIs().equals(that.right.asIs())) {
            return true;
        } else if (this.top.asIs().equals(that.bottom.asIs())) {
            return true;
        } else if (this.top.asIs().equals(that.left.asIs())) {
            return true;
        } else if (this.right.asIs().equals(that.top.asIs())) {
            return true;
        } else if (this.right.asIs().equals(that.right.asIs())) {
            return true;
        } else if (this.right.asIs().equals(that.bottom.asIs())) {
            return true;
        } else if (this.right.asIs().equals(that.left.asIs())) {
            return true;
        } else if (this.bottom.asIs().equals(that.top.asIs())) {
            return true;
        } else if (this.bottom.asIs().equals(that.right.asIs())) {
            return true;
        } else if (this.bottom.asIs().equals(that.bottom.asIs())) {
            return true;
        } else if (this.bottom.asIs().equals(that.left.asIs())) {
            return true;
        } else if (this.left.asIs().equals(that.top.asIs())) {
            return true;
        } else if (this.left.asIs().equals(that.right.asIs())) {
            return true;
        } else if (this.left.asIs().equals(that.bottom.asIs())) {
            return true;
        } else if (this.left.asIs().equals(that.left.asIs())) {
            return true;
        } else if (this.top.asIs().equals(that.top.reversed())) {
            return true;
        } else if (this.top.asIs().equals(that.right.reversed())) {
            return true;
        } else if (this.top.asIs().equals(that.bottom.reversed())) {
            return true;
        } else if (this.top.asIs().equals(that.left.reversed())) {
            return true;
        } else if (this.right.asIs().equals(that.top.reversed())) {
            return true;
        } else if (this.right.asIs().equals(that.right.reversed())) {
            return true;
        } else if (this.right.asIs().equals(that.bottom.reversed())) {
            return true;
        } else if (this.right.asIs().equals(that.left.reversed())) {
            return true;
        } else if (this.bottom.asIs().equals(that.top.reversed())) {
            return true;
        } else if (this.bottom.asIs().equals(that.right.reversed())) {
            return true;
        } else if (this.bottom.asIs().equals(that.bottom.reversed())) {
            return true;
        } else if (this.bottom.asIs().equals(that.left.reversed())) {
            return true;
        } else if (this.left.asIs().equals(that.top.reversed())) {
            return true;
        } else if (this.left.asIs().equals(that.right.reversed())) {
            return true;
        } else if (this.left.asIs().equals(that.bottom.reversed())) {
            return true;
        } else if (this.left.asIs().equals(that.left.reversed())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Image: " + tileId + "\n Up - " + top + "\n Right - " + right + "\n Down - " + bottom + "\n Left - " + left;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return tileId == image.tileId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tileId);
    }
}
