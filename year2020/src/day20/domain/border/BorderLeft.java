package day20.domain.border;

import day20.domain.Image;

import static day20.domain.border.Orientation.LEFT;

public class BorderLeft extends Border {

    public BorderLeft(Image parent) {
        super(parent, BorderLeft::getLeftCharacters);
    }

    @Override
    public Orientation getOrientation() {
        return LEFT;
    }

    private static String getLeftCharacters(String raw) {
        String[] lines = raw.split("\n");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            builder.append(lines[i].charAt(0));
        }
        return builder.reverse().toString();
    }
}
