package day03;

import day03.domain.Dendrologist;
import day03.domain.Path;
import day03.domain.Position;
import day03.domain.RepeatingMap;
import day03.parsers.MapParser;

import java.time.LocalTime;
import java.util.function.Supplier;

import static java.time.Duration.between;
import static java.time.LocalTime.now;
import static java.util.List.of;

public class Challenge03 {

    public static void main(String[] args) {
        Challenge03 challenge = new Challenge03();
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
        System.out.println("-------------- Running y2020-d03-1...");

        RepeatingMap map = MapParser.parse(RawData03.input);

        long result = new Dendrologist().countTrees(map, new Position(0, 0), new Path(3, 1));

        return "Number of Trees: " + result;
    }

    public String solution2() {
        System.out.println("-------------- Running y2020-d03-2...");

        RepeatingMap map = MapParser.parse(RawData03.input);

        Dendrologist dendrologist = new Dendrologist();
        long result = of(new Path(1, 1), new Path(3, 1), new Path(5, 1), new Path(7, 1), new Path(1, 2)).stream()
                .mapToLong(path -> dendrologist.countTrees(map, new Position(0, 0), path))
                .reduce(1, (left, right) -> left * right);

        return "Number of Trees: " + result;
    }
}
