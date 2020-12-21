package day02.domain;

public class Password {

    private final String value;
    private final PasswordPolicy policy;

    public Password(String value, PasswordPolicy policy) {
        this.value = value;
        this.policy = policy;
    }

    public boolean isValidAtSledRental() {
        return policy.allowedForRentalPlace(value);
    }

    public boolean isValidAtTobogganCorporate() {
        return policy.allowedForTobogganCorporate(value);
    }
}
