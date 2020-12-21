package day03.parsers;

import day03.domain.RepeatingMap;

public class MapParser {

    public static RepeatingMap parse(String input) {
        return new RepeatingMap(input);
    }
}
