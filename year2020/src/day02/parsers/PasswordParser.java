package day02.parsers;

import day02.domain.Password;
import day02.domain.PasswordPolicy;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class PasswordParser {

    private static final String REGEX = "(\\d+)-(\\d+) (.): (.*)";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    public static List<Password> parse(String input) {
        return stream(input.split("\n")).map(PasswordParser::parseLine).collect(toList());
    }

    private static Password parseLine(String line) {
        Matcher matcher = PATTERN.matcher(line);
        if (!matcher.matches()) {
            throw new RuntimeException("Regex did not match line.");
        }

        int lowest = parseInt(matcher.group(1));
        int highest = parseInt(matcher.group(2));
        String character = matcher.group(3);
        String password = matcher.group(4);

        return new Password(password, new PasswordPolicy(character, lowest, highest));
    }
}
