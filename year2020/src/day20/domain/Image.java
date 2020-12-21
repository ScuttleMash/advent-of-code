package day20.domain;

import day20.domain.border.*;

import java.util.List;
import java.util.Objects;

import static java.util.List.of;

public class Image {

    private final long tileId;
    private final String data;

    private List<Border> borders;

    public Image(Image image) {
        this.tileId = image.tileId;
        this.data = image.data;
        this.borders = of(new BorderTop(this), new BorderRight(this), new BorderBottom(this), new BorderLeft(this));
    }

    public Image(long tileId, String data) {
        this.tileId = tileId;
        this.data = data;
        this.borders = of(new BorderTop(this), new BorderRight(this), new BorderBottom(this), new BorderLeft(this));
    }

    public long getTileId() {
        return tileId;
    }

    List<Border> getBorders() {
        return borders;
    }

    public boolean isAdjacentTo(Image that) {
        if (this.equals(that)) {
            return false;
        }

        return this.borders.stream().anyMatch(border -> border.findMatchingBorders(that.borders).isMatch());
    }

    @Override
    public String toString() {
        return "Image: " + tileId;
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

    public String getContent() {
        return data;
    }
}
