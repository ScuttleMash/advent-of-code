package day02.domain;

public class PasswordPolicy {

    private final String character;
    private final int lowest;
    private final int highest;

    public PasswordPolicy(String character, int lowest, int highest) {
        this.character = character;
        this.lowest = lowest;
        this.highest = highest;
    }

    public boolean allowedForRentalPlace(String value) {
        long occurrences = value.chars().filter(c -> c == character.charAt(0)).count();
        return lowest <= occurrences && occurrences <= highest;
    }

    public boolean allowedForTobogganCorporate(String value) {
        char first = value.charAt(lowest - 1);
        char second = value.charAt(highest - 1);
        char target = character.charAt(0);

        return first != second && (first == target || second == target);
    }
}
