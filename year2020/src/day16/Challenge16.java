package day16;

import day16.domain.Criteria;
import day16.domain.DataPerIndex;
import day16.domain.Ticket;
import day16.parsers.CriteriaParser;
import day16.parsers.TicketParser;

import java.time.LocalTime;
import java.util.List;
import java.util.function.Supplier;

import static java.time.Duration.between;
import static java.time.LocalTime.now;
import static java.util.stream.Collectors.toList;

public class Challenge16 {

    public static final int CRITERIA = 20;

    public static void main(String[] args) {
        Challenge16 challenge16 = new Challenge16();
        execute(challenge16::solution1);
        execute(challenge16::solution2);
    }

    public static void execute(Supplier<String> solution) {
        LocalTime start = now();
        String answer = solution.get();
        System.out.println("Solution --- " + answer + " --- Solved in " + between(start, now()).toMillis() + "ms.");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------------");
    }

    public String solution1() {
        System.out.println("-------------- Running y2020-d16-1...");

        List<Criteria> criteria = CriteriaParser.parse(RawData16.criteria);
        List<Ticket> tickets = TicketParser.parse(RawData16.otherTickets);

        long ticketScanningErrorRate = tickets.stream()
                .mapToLong(ticket -> ticket.getInvalidValuesSum(criteria))
                .sum();

        return "Ticket Scanning Error Rate: " + ticketScanningErrorRate;
    }

    public String solution2() {
        System.out.println("-------------- Running y2020-d16-2...");

        List<Criteria> criteria = CriteriaParser.parse(RawData16.criteria);
        List<Ticket> validTickets = TicketParser.parse(RawData16.otherTickets).stream()
                .filter(ticket -> ticket.isValid(criteria))
                .collect(toList());
        Ticket myTicket = TicketParser.parse(RawData16.myTicket)
                .get(0);

        DataPerIndex dataPerIndex = new DataPerIndex(validTickets);
        while (criteria.stream().anyMatch(x -> !x.hasTicketIndex())) {
            criteria.forEach(dataPerIndex::markOnlyMatchWith);
        }

        long result = criteria.stream()
                .filter(Criteria::isDepartureCriteria)
                .mapToLong(myTicket::getValueForCriteria)
                .reduce(1, (left, right) -> left * right);

        return "Multiplication of Departure Fields: " + result;
    }
}
