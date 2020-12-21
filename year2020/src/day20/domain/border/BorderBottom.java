package day20.domain.border;

import day20.domain.Image;

import static day20.domain.border.Orientation.BOTTOM;

public class BorderBottom extends Border {

    public BorderBottom(Image parent) {
        super(parent, BorderBottom::getLastLine);
    }

    @Override
    public Orientation getOrientation() {
        return BOTTOM;
    }

    private static String getLastLine(String raw) {
        String[] lines = raw.split("\n");
        return new StringBuilder(lines[lines.length - 1]).reverse().toString();
    }
}
