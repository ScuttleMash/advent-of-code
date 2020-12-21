package day01.parsers;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.toList;

public class ExpensesParser {

    public static List<Integer> parse(String input) {
        return stream(input.split("\n")).map(Integer::parseInt).collect(toList());
    }

}
