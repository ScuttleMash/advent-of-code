package day03.domain;

import java.util.List;

public class RepeatingMap {

    private static final Character TREE = '#';

    private final String[] map;
    private final int mapWidth;

    public RepeatingMap(String map) {
        this.map = map.split("\n");
        this.mapWidth = this.map[0].length();
    }

    public Position navigate(Position position, Path path) {
        Position next = new Position(position.getFromLeft() + path.getStepRight(), position.getFromTop() + path.getStepDown());
        if (next.getFromTop() >= map.length) {
            return null;
        }

        return next;
    }

    public long checkForTreesAt(List<Position> positions) {
        return positions.stream().map(this::getSymbol).filter(TREE::equals).count();
    }

    private char getSymbol(Position position) {
        return getSymbol(position.getFromTop(), position.getFromLeft());
    }

    private char getSymbol(int fromTop, int fromLeft) {
        return map[fromTop].charAt(fromLeft % mapWidth);
    }
}
