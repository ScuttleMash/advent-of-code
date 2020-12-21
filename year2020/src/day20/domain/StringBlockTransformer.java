package day20.domain;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

public class StringBlockTransformer {

    public String mirror(String original) {
        String[] rows = original.split("\n");
        return stream(rows).map(row -> new StringBuilder(row).reverse().toString()).collect(joining("\n"));
    }

    public String rotate90degrees(String original) {
        StringBuilder result = new StringBuilder();

        String[] rows = original.split("\n");
        for (int columnIndex = 0; columnIndex < rows[0].length(); columnIndex++) {
            for (int rowIndex = rows.length - 1; rowIndex >= 0; rowIndex--) {
                result.append(rows[rowIndex].charAt(columnIndex));
            }
            if (columnIndex != rows[0].length() - 1) {
                result.append("\n");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        StringBlockTransformer rotator = new StringBlockTransformer();

        testEquals(rotator.rotate90degrees("123"), "1\n2\n3");
        testEquals(rotator.rotate90degrees("1\n2\n3"), "321");
        testEquals(rotator.rotate90degrees("123\n456\n789"), "741\n852\n963");
        testEquals(rotator.mirror("123"), "321");
        testEquals(rotator.mirror("1\n2\n3"), "1\n2\n3");
        testEquals(rotator.mirror("123\n456\n789"), "321\n654\n987");
    }

    public static void testEquals(String one, String two) {
        if (!one.equals(two)) {
            throw new RuntimeException(one + " is not equal to " + two);
        }
    }

    public String rotate180degrees(String data) {
        return rotate90degrees(rotate90degrees(data));
    }

    public String rotate270degrees(String data) {
        return rotate90degrees(rotate180degrees(data));
    }
}
