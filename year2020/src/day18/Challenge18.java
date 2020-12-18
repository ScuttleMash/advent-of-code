package day18;

import day18.domain.Equation;
import day18.parsers.EquationParser;

import java.time.LocalTime;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.time.Duration.between;
import static java.time.LocalTime.now;
import static java.util.stream.Collectors.*;

public class Challenge18 {

    public static void main(String[] args) {
        Challenge18 challenge = new Challenge18();
        execute(challenge::solution1);
        execute(challenge::solution2);
    }

    public static void execute(Supplier<String> solution) {
        LocalTime start = now();
        String answer = solution.get();
        System.out.println("Solution --- " + answer + " --- Solved in " + between(start, now()).toMillis() + "ms.");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------------");
    }

    public String solution1() {
        System.out.println("-------------- Running y2020-d18-1...");

        List<Equation> equations = EquationParser.parse(RawData18.equations);

        long result = equations.stream().mapToLong(Equation::solve).sum();

        return "Sum of Equations: " + result;
    }

    public String solution2() {
        System.out.println("-------------- Running y2020-d18-2...");

        return "???";
    }
}
