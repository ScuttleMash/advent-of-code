package day20;

import day20.domain.Image;
import day20.domain.Picture;
import day20.parsers.ImageParser;

import java.time.LocalTime;
import java.util.List;
import java.util.function.Supplier;

import static java.time.Duration.between;
import static java.time.LocalTime.now;

public class Challenge20 {

    public static void main(String[] args) {
        Challenge20 challenge = new Challenge20();
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
        System.out.println("-------------- Running y2020-d20-1...");

        List<Image> images = ImageParser.parse(RawData20.raw);

        long result = new Picture(images)
                .getCorners()
                .stream()
                .mapToLong(Image::getTileId)
                .reduce(1, (left, right) -> left * right);

        return "Product of Corners: " + result;
    }

    public String solution2() {
        System.out.println("-------------- Running y2020-d20-2...");

        List<Image> images = ImageParser.parse(RawData20.test);

        return "Objects != Sea Monsters: ???";
    }
}
