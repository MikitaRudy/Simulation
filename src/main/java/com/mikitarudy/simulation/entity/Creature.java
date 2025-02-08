package main.java.com.mikitarudy.simulation.entity;

import main.java.com.mikitarudy.simulation.map.Position;
import main.java.com.mikitarudy.simulation.map.WorldMap;
import main.java.com.mikitarudy.simulation.pathfinding.PathFinder;
import main.java.com.mikitarudy.simulation.tool.Constants;

import java.util.List;

public abstract class Creature extends Entity {
    public Creature(String emoji) {
        super(emoji);
    }

    public void makeMove(WorldMap map, PathFinder pathFinder) {
        Position currentPos = map.getPositionOf(this);
        if (currentPos == null){
            return;
        }
        Position targetPos = pathFinder.findNearestEntity(currentPos, getTargetType());
        if (targetPos == null){
            return;
        }
        List<Position> path = pathFinder.findPath(currentPos, targetPos, getTargetType());
        if (path == null || path.size() < 2){
            return;
        }
        Position nextStep = path.get(1);
        if (map.isPositionEmpty(nextStep)) {
            map.moveEntity(currentPos, nextStep);
        }
        if (nextStep.equals(targetPos)) {
            handleTargetReached(map, targetPos);
            map.moveEntity(currentPos, nextStep);
        }
        System.out.printf(Constants.MOVE_LOG, this.getClass().getSimpleName(), currentPos, nextStep);
    }

    protected abstract Class<? extends Entity> getTargetType();

    protected abstract void handleTargetReached(WorldMap map, Position targetPos);
}
