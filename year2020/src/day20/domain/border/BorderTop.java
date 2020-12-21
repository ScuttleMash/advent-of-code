package day20.domain.border;

import day20.domain.Image;

import static day20.domain.border.Orientation.TOP;

public class BorderTop extends Border {

    public BorderTop(Image parent) {
        super(parent, BorderTop::getFirstLine);
    }

    @Override
    public Orientation getOrientation() {
        return TOP;
    }

    private static String getFirstLine(String raw) {
        return raw.split("\n")[0];
    }
}
