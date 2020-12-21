package day03.domain;

import java.util.ArrayList;
import java.util.List;

public class Dendrologist {

    public long countTrees(RepeatingMap map, Position start, Path path) {
        List<Position> visited = new ArrayList<>();
        Position current = start;
        while (current != null) {
            visited.add(current);
            current = map.navigate(current, path);
        }
        return map.checkForTreesAt(visited);
    }
}
