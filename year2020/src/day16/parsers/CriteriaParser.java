package day16.parsers;

import day16.domain.Criteria;
import day16.domain.Range;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class CriteriaParser {

    private static final String REGEX = "(.*) (\\d+)-(\\d+) or (\\d+)-(\\d+)";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    public static List<Criteria> parse(String criteriaString) {
        String[] criteriaLines = criteriaString.split("\n");
        return stream(criteriaLines).map(CriteriaParser::map).collect(toList());
    }

    private static Criteria map(String line) {
        Matcher matcher = PATTERN.matcher(line);
        if (!matcher.matches()) {
            throw new RuntimeException("Could not parse data...");
        }

        String name = matcher.group(1);
        Range rangeOne = new Range(parseInt(matcher.group(2)), parseInt(matcher.group(3)));
        Range rangeTwo = new Range(parseInt(matcher.group(4)), parseInt(matcher.group(5)));
        return new Criteria(name, rangeOne, rangeTwo);
    }
}
