package day16.domain;

import java.util.List;

public class Ticket {

    private final List<Integer> values;

    public Ticket(List<Integer> values) {
        this.values = values;
    }

    public boolean isValid(List<Criteria> criteria) {
        return values.stream().allMatch(value -> isValid(value, criteria));
    }

    private boolean isValid(int value, List<Criteria> criteria) {
        return criteria.stream().anyMatch(cur -> cur.isValidFor(value));
    }

    public int getInvalidValuesSum(List<Criteria> criteria) {
        return values.stream().mapToInt(value -> value).filter(value -> !isValid(value, criteria)).sum();
    }

    public int getValueForCriteria(Criteria criteria) {
        return values.get(criteria.getTicketIndex());
    }

    public int getValueAtIndex(int index) {
        return values.get(index);
    }
}
