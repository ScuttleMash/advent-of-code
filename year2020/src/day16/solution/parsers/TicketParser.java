package day16.solution.parsers;

import day16.solution.domain.Ticket;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toUnmodifiableList;

public class TicketParser {

    public static List<Ticket> parse(String ticketsString) {
        String[] ticketLines = ticketsString.split("\n");
        return stream(ticketLines).map(TicketParser::map).collect(toList());
    }

    private static Ticket map(String line) {
        List<Integer> values = stream(line.split(",")).map(Integer::parseInt).collect(toUnmodifiableList());
        return new Ticket(values);
    }
}
