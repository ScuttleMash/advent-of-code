package day20.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static day20.domain.border.Orientation.*;
import static java.util.stream.Collectors.*;

public class Picture {

    private final List<Image> images;

    public Picture(List<Image> images) {
        this.images = images;
    }

    public List<Image> getCorners() {
        List<Image> result = new ArrayList<>();
        for (Image image : images) {
            if (images.stream().filter(image::isAdjacentTo).count() == 2) {
                result.add(image);
            }
        }
        return result;
    }
}
