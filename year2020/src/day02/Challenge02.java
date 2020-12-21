package day02;

import day02.domain.Password;
import day02.parsers.PasswordParser;

import java.time.LocalTime;
import java.util.List;
import java.util.function.Supplier;

import static java.time.Duration.between;
import static java.time.LocalTime.now;

public class Challenge02 {

    public static void main(String[] args) {
        Challenge02 challenge = new Challenge02();
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
        System.out.println("-------------- Running y2020-d02-1...");

        List<Password> passwords = PasswordParser.parse(RawData02.input);

        long validPasswords = passwords.stream().filter(Password::isValidAtSledRental).count();

        return "Valid passwords at Sled Rental: " + validPasswords;
    }

    public String solution2() {
        System.out.println("-------------- Running y2020-d02-2...");

        List<Password> passwords = PasswordParser.parse(RawData02.input);

        long validPasswords = passwords.stream().filter(Password::isValidAtTobogganCorporate).count();

        return "Valid passwords at Toboggan Corporate: " + validPasswords;
    }
}
