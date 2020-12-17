package day17.domain;

import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Math.abs;
import static java.util.stream.IntStream.*;

public class ActivePoint {

    private int[] coordinates;

    public ActivePoint(int... coordinates) {
        this.coordinates = coordinates;
    }

    public ActivePoint(List<Integer> position) {
        this.coordinates = position.stream().mapToInt(x -> x).toArray();
    }

    public ActivePoint ascendToDimension(int dimensions) {
        if (dimensions < coordinates.length) {
            throw new RuntimeException("Point has no interest in lowering its dimensional presence.");
        } else if (dimensions == coordinates.length) {
            return this;
        } else {
            int[] newPoint = new int[dimensions];
            range(0, coordinates.length).forEach(index -> newPoint[index] = coordinates[index]);
            return new ActivePoint(newPoint);
        }
    }

    public boolean isEqualTo(List<Integer> position) {
        if (this.coordinates.length != position.size()) {
            throw new RuntimeException("Points belong to different dimensions!");
        }

        return range(0, coordinates.length).allMatch(index -> this.coordinates[index] == position.get(index));
    }

    public boolean isAdjacentTo(List<Integer> position) {
        if (this.coordinates.length != position.size()) {
            throw new RuntimeException("Points belong to different dimensions!");
        }
        return range(0, coordinates.length).allMatch(index -> withinOne(this.coordinates[index], position.get(index)));
    }

    private boolean withinOne(int left, int right) {
        return abs(left - right) <= 1;
    }

    public int getPositionInDimension(int dimension) {
        if (dimension >= coordinates.length) {
            throw new RuntimeException("Point has no awareness of this dimension.");
        }
        return coordinates[dimension];
    }

    public int getDimension() {
        return coordinates.length;
    }
}
