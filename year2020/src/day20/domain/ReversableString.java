package day20.domain;

public class ReversableString {

    private final String value;

    public ReversableString(String value) {
        this.value = value;
    }

    public String asIs() {
        return value;
    }

    public String reversed() {
        return new StringBuilder(value).reverse().toString();
    }
}
