package day17.parsers;

import day17.domain.ActivePoint;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class PointParser {

    public static List<ActivePoint> parse(String input) {
        String[] lines = input.split("\n");
        return IntStream.range(0, lines.length)
                .mapToObj(index -> toActivePoints(index, lines[index]))
                .flatMap(Collection::stream)
                .collect(toList());
    }

    private static List<ActivePoint> toActivePoints(int lineIndex, String line) {
        return IntStream.range(0, line.length())
                .mapToObj(charIndex -> toActivePointOrNull(lineIndex, charIndex, line.charAt(charIndex)))
                .filter(Objects::nonNull)
                .collect(toList());
    }

    private static ActivePoint toActivePointOrNull(int lineIndex, int charIndex, char charAtIndex) {
        if (charAtIndex == '#') {
            return new ActivePoint(charIndex, lineIndex);
        }
        return null;
    }
}
