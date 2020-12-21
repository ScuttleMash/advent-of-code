package day01;

import day01.parsers.ExpensesParser;

import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

import static java.time.Duration.between;
import static java.time.LocalTime.now;

public class Challenge01 {

    public static void main(String[] args) {
        Challenge01 challenge = new Challenge01();
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
        System.out.println("-------------- Running y2020-d01-1...");

        List<Integer> expenses = ExpensesParser.parse(RawData01.input);

        AtomicInteger firstExpense = new AtomicInteger();
        AtomicInteger secondExpense = new AtomicInteger();
        expenses.forEach(left -> expenses.forEach(right -> {
            if (left + right == 2020) {
                firstExpense.set(left);
                secondExpense.set(right);
            }
        }));

        return "Product of Expenses: " + firstExpense.get() * secondExpense.get();
    }

    public String solution2() {
        System.out.println("-------------- Running y2020-d01-2...");

        List<Integer> expenses = ExpensesParser.parse(RawData01.input);

        AtomicInteger firstExpense = new AtomicInteger();
        AtomicInteger secondExpense = new AtomicInteger();
        AtomicInteger thirdExpense = new AtomicInteger();
        expenses.forEach(first -> expenses.forEach(second -> expenses.forEach(third -> {
            if (first + second + third == 2020) {
                firstExpense.set(first);
                secondExpense.set(second);
                thirdExpense.set(third);
            }
        })));

        return "Product of Expenses: " + firstExpense.get() * secondExpense.get() * thirdExpense.get();
    }
}
