package day17.domain.cycle;

import day17.domain.ActivePoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Collections.emptyList;
import static java.util.List.copyOf;
import static java.util.List.of;
import static java.util.stream.Collectors.toList;

public class Dimension {

    private final int min;
    private final int max;
    private final Dimension lowerDimension;

    public Dimension(int min, int max, Dimension lowerDimension) {
        this.min = min;
        this.max = max;
        this.lowerDimension = lowerDimension;
    }

    public List<ActivePoint> calculateNewPointsBasedOn(List<ActivePoint> points) {
        return calculateNewPointsBasedOn(points, emptyList());
    }

    private List<ActivePoint> calculateNewPointsBasedOn(List<ActivePoint> points, List<Integer> position) {
        List<ActivePoint> result = new ArrayList<>();
        IntStream.range(min, max + 1)
                .forEach(index -> {
                    List<Integer> positionPlus = new ArrayList<>(position);
                    positionPlus.add(index);
                    if (points.get(0).getDimension() == positionPlus.size()) {
                        Collections.reverse(positionPlus);
                        List<ActivePoint> nearby = points.stream().filter(point -> point.isAdjacentTo(positionPlus)).collect(toList());
                        boolean active = nearby.stream().anyMatch(point -> point.isEqualTo(positionPlus));
                        if (active && (nearby.size() == 3 || nearby.size() == 4)) {
                            result.add(new ActivePoint(positionPlus));
                        } else if (!active && nearby.size() == 3) {
                            result.add(new ActivePoint(positionPlus));
                        }
                    } else {
                        result.addAll(lowerDimension.calculateNewPointsBasedOn(points, positionPlus));
                    }
                });
        return result;
    }
}
