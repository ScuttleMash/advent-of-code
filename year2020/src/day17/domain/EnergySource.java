package day17.domain;

import day17.domain.cycle.MomentInTime;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class EnergySource {

    private final List<ActivePoint> points;

    public static EnergySource inThirdDimension(List<ActivePoint> points) {
        return new EnergySource(3, points);
    }

    public static EnergySource inFourthDimension(List<ActivePoint> points) {
        return new EnergySource(4, points);
    }

    private EnergySource(int dimensions, List<ActivePoint> points) {
        this.points = bringIntoHigherDimensions(dimensions, points);
    }

    private EnergySource(List<ActivePoint> points) {
        this.points = points;
    }

    private List<ActivePoint> bringIntoHigherDimensions(int dimensions, List<ActivePoint> points) {
        if (points.size() == 0) {
            throw new RuntimeException("I cannot make something out of nothing.");
        }

        return points.stream().map(point -> point.ascendToDimension(dimensions)).collect(toList());
    }

    public EnergySource cycle(int times) {
        MomentInTime momentInTime = new MomentInTime(points);
        for (int i = 0; i < times; i++) {
            System.out.println("====================> START CYCLE " + i);
            momentInTime = momentInTime.advance();
            System.out.println("====================> END CYCLE " + i);
        }
        return new EnergySource(momentInTime.getActivePoints());
    }

    public int getCubeCount() {
        return points.size();
    }
}
