package main.java.com.mikitarudy.simulation.pathfinding;

import main.java.com.mikitarudy.simulation.entity.Entity;
import main.java.com.mikitarudy.simulation.map.Position;
import main.java.com.mikitarudy.simulation.map.WorldMap;

import java.util.*;

public class PathFinder {
    private final WorldMap map;

    public PathFinder(WorldMap map) {
        this.map = map;
    }

    public <T extends Entity> List<Position> findPath(Position start, Position end, Class<T> targetType) {
        Queue<Position> queue = new LinkedList<>();
        Map<Position, Position> cameFrom = new HashMap<>();
        queue.add(start);
        cameFrom.put(start, null);

        while (!queue.isEmpty()) {
            Position current = queue.poll();
            if (current.equals(end)) {
                return reconstructPath(cameFrom, current);
            }
            for (Position neighbor : getNeighbors(current)) {
                if (!cameFrom.containsKey(neighbor) && isPositionAccessible(neighbor, targetType)) {
                    queue.add(neighbor);
                    cameFrom.put(neighbor, current);
                }
            }
        }
        return null;
    }

    private List<Position> reconstructPath(Map<Position, Position> cameFrom, Position current) {
        List<Position> path = new ArrayList<>();
        while (current != null) {
            path.add(current);
            current = cameFrom.get(current);
        }
        Collections.reverse(path);
        return path;
    }

    private List<Position> getNeighbors(Position pos) {
        List<Position> neighbors = new ArrayList<>();
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : directions) {
            int newX = pos.getX() + dir[0];
            int newY = pos.getY() + dir[1];
            Position neighbor = new Position(newX, newY);
            if (map.isPositionValid(neighbor)) {
                neighbors.add(neighbor);
            }
        }
        return neighbors;
    }

    public <T extends Entity> Position findNearestEntity(Position start, Class<T> targetType) {
        Queue<Position> queue = new LinkedList<>();
        Set<Position> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Position current = queue.poll();
            Entity entity = map.getEntity(current);
            if (entity != null && targetType.isInstance(entity)) {
                return current;
            }
            for (Position neighbor : getNeighbors(current)) {
                if (!visited.contains(neighbor) && isPositionAccessible(neighbor, targetType)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return null;
    }

    private boolean isPositionAccessible(Position pos, Class<? extends Entity> targetType) {
        if (!map.isPositionValid(pos)) {
            return false;
        }
        Entity entity = map.getEntity(pos);
        return entity == null || targetType.isInstance(entity);
    }
}
