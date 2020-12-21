package day20.domain.border;

import day20.domain.Image;

import static day20.domain.border.Orientation.RIGHT;

public class BorderRight extends Border {

    public BorderRight(Image parent) {
        super(parent, BorderRight::getRightCharacters);
    }


    @Override
    public Orientation getOrientation() {
        return RIGHT;
    }

    private static String getRightCharacters(String raw) {
        String[] lines = raw.split("\n");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            builder.append(lines[i].charAt(lines[i].length() - 1));
        }
        return builder.toString();
    }
}
