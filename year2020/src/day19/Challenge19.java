package day19;

import java.time.LocalTime;
import java.util.function.Supplier;

import static java.time.Duration.between;
import static java.time.LocalTime.now;

public class Challenge19 {

    public static void main(String[] args) {
        Challenge19 challenge = new Challenge19();
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
        System.out.println("-------------- Running y2020-d19-1...");

        return "???";
    }

    public String solution2() {
        System.out.println("-------------- Running y2020-d19-2...");

        return "???";
    }
}
