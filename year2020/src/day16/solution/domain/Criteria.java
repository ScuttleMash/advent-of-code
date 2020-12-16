package day16.solution.domain;

import java.util.List;
import java.util.Set;

import static java.util.List.of;
import static java.util.stream.Collectors.joining;

public class Criteria {

    private final String name;
    private final List<Range> allowedRanges;

    private int ticketIndex = -1;

    public Criteria(String name, Range... allowedRanges) {
        this.name = name;
        this.allowedRanges = of(allowedRanges);
    }

    public boolean isValidFor(int value) {
        return allowedRanges.stream().anyMatch(range -> range.contains(value));
    }

    public boolean isValidFor(Set<Integer> values) {
        return values.stream().allMatch(this::isValidFor);
    }

    public boolean isDepartureCriteria() {
        return name.startsWith("departure");
    }

    public int getTicketIndex() {
        return ticketIndex;
    }

    public void setTicketIndex(int ticketIndex) {
        this.ticketIndex = ticketIndex;
    }

    @Override
    public String toString() {
        return "Criteria " + name + " [" + allowedRanges.stream().map(Object::toString).collect(joining(", ")) + "]";
    }

    public boolean hasTicketIndex() {
        return ticketIndex != -1;
    }
}
