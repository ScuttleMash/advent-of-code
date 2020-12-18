package day18.parsers;

import day18.domain.Equation;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class EquationParser {

    public static List<Equation> parse(String input) {
        String[] rawEquations = input.split("\n");
        return Arrays.stream(rawEquations)
                .map(raw -> raw.replace(" ", ""))
                .map(Equation::new)
                .collect(toList());
    }
}
