package day17.domain.cycle;

import day17.domain.ActivePoint;
import day17.domain.DimensionBorder;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class MomentInTime {

    private final List<ActivePoint> points;
    private final List<DimensionBorder> borders;

    public MomentInTime(List<ActivePoint> points) {
        this.points = points;
        this.borders = calculateBorders(points);
    }

    public MomentInTime advance() {
        return new MomentInTime(calculateAdvancedPoints(points, borders));
    }

    private static List<ActivePoint> calculateAdvancedPoints(List<ActivePoint> points, List<DimensionBorder> borders) {
        List<Dimension> dimensions = new ArrayList<>();
        Dimension previousDimension = null;
        for (DimensionBorder border : borders) {
            Dimension newDimension = new Dimension(border.getMin(), border.getMax(), previousDimension);
            dimensions.add(newDimension);
            previousDimension = newDimension;
        }
        return previousDimension.calculateNewPointsBasedOn(points);
    }

    public List<ActivePoint> getActivePoints() {
        return points;
    }

    private static List<DimensionBorder> calculateBorders(List<ActivePoint> points) {
        return IntStream.range(0, points.get(0).getDimension())
                .mapToObj(dimension -> calculateBorderForDimension(points, dimension))
                .collect(toList());
    }

    private static DimensionBorder calculateBorderForDimension(List<ActivePoint> points, int dimension) {
        IntSummaryStatistics summary = points.stream()
                .mapToInt(point -> point.getPositionInDimension(dimension))
                .summaryStatistics();
        return new DimensionBorder(dimension, summary.getMin() - 1, summary.getMax() + 1);
    }
}

/**
 *  * int cubeCount = threeDimensionsGridAroundCell.countActives();
 *  * if (active && (cubeCount == 3 || cubeCount == 4)) {
 *  * return true;
 *  * } else if (!active && cubeCount == 3) {
 *  * return true;
 *  * } else {
 *  * return false;
 */
