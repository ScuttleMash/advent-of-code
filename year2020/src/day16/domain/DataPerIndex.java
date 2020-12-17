package day16.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static day16.Challenge16.CRITERIA;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class DataPerIndex {

    private List<Set<Integer>> data;
    private Boolean[] used = new Boolean[CRITERIA];

    public DataPerIndex(List<Ticket> validTickets) {
        data = IntStream.range(0, CRITERIA)
                .mapToObj(index -> validTickets.stream()
                        .map(ticket -> ticket.getValueAtIndex(index))
                        .collect(toSet()))
                .collect(toList());
        IntStream.range(0, CRITERIA).forEach(x -> used[x] = false);
    }

    public void markOnlyMatchWith(Criteria criteria) {
        int[] matches = IntStream.range(0, CRITERIA)
                .filter(index -> !used[index])
                .filter(index -> criteria.isValidFor(data.get(index)))
                .toArray();

        if (matches.length == 1) {
            criteria.setTicketIndex(matches[0]);
            used[matches[0]] = true;
        }
    }
}