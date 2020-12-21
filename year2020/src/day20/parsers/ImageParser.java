package day20.parsers;

import day20.domain.Image;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
        String content = stream(lines).skip(1).collect(Collectors.joining("\n"));
        return new Image(imageId, content);
    }

    private static int parseImageId(String line) {
        Matcher matcher = ID_PATTERN.matcher(line);
        if (!matcher.matches()) {
            throw new RuntimeException("Could not parse data...");
        }

        return parseInt(matcher.group(1));
    }
}