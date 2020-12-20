package day20.parsers;

import day20.domain.Image;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class ImageParser {

    private static final String ID_REGEX = "Tile (\\d+):";
    private static final Pattern ID_PATTERN = Pattern.compile(ID_REGEX);

    public static List<Image> parse(String rawInput) {
        String[] rawImages = rawInput.split("\\n\\n");
        return stream(rawImages).map(ImageParser::parseOne).collect(toList());
    }

    private static Image parseOne(String rawImage) {
        String[] lines = rawImage.split("\n");
        int imageId = parseImageId(lines[0]);
        String top = lines[1];
        String right = lastCharacterOfEachLine(lines);
        String bottom = new StringBuilder(lines[lines.length - 1]).reverse().toString();
        String left = firstCharacterOfEachLine(lines);
        return new Image(imageId, top, right, bottom, left);
    }

    private static int parseImageId(String line) {
        Matcher matcher = ID_PATTERN.matcher(line);
        if (!matcher.matches()) {
            throw new RuntimeException("Could not parse data...");
        }

        return parseInt(matcher.group(1));
    }

    private static String firstCharacterOfEachLine(String[] lines) {
        return characterOfEachLineAtIndex(lines, 0);
    }

    private static String lastCharacterOfEachLine(String[] lines) {
        return characterOfEachLineAtIndex(lines, lines[1].length() - 1);
    }

    private static String characterOfEachLineAtIndex(String[] lines, int index) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < lines.length; i++) {
            builder.append(lines[i].charAt(index));
        }
        return builder.reverse().toString();
    }
}
