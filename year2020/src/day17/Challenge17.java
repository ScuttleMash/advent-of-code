package day17;

import day17.domain.ActivePoint;
import day17.domain.EnergySource;
import day17.parsers.PointParser;

import java.time.LocalTime;
import java.util.List;
import java.util.function.Supplier;

import static java.time.Duration.between;
import static java.time.LocalTime.now;

public class Challenge17 {

    public static void main(String[] args) {
        Challenge17 challenge17 = new Challenge17();
        execute(challenge17::solution1);
        execute(challenge17::solution2);
    }

    public static void execute(Supplier<String> solution) {
        LocalTime start = now();
        String answer = solution.get();
        System.out.println("Solution --- " + answer + " --- Solved in " + between(start, now()).toMillis() + "ms.");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------------");
    }

    public String solution1() {
        System.out.println("-------------- Running y2020-d17-1...");

        List<ActivePoint> points = PointParser.parse(RawData17.conwayInput);

        int result = EnergySource.inThirdDimension(points).cycle(6).getCubeCount();

        return "Cube Count: " + result;
    }

    public String solution2() {
        System.out.println("-------------- Running y2020-d17-2...");

        List<ActivePoint> points = PointParser.parse(RawData17.conwayInput);

        int result = EnergySource.inFourthDimension(points).cycle(6).getCubeCount();

        return "Cube Count: " + result;
    }
}
