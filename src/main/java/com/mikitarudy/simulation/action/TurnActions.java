package main.java.com.mikitarudy.simulation.action;

import main.java.com.mikitarudy.simulation.entity.Creature;
import main.java.com.mikitarudy.simulation.entity.Grass;
import main.java.com.mikitarudy.simulation.entity.Herbivore;
import main.java.com.mikitarudy.simulation.map.Position;
import main.java.com.mikitarudy.simulation.map.WorldMap;
import main.java.com.mikitarudy.simulation.pathfinding.PathFinder;
import main.java.com.mikitarudy.simulation.tool.Constants;
import main.java.com.mikitarudy.simulation.tool.FindEmptyPositionTool;
import main.java.com.mikitarudy.simulation.tool.WorldMapPrintTool;

import java.util.List;

public class TurnActions extends Action {
    private final WorldMap worldMap;
    private final PathFinder pathFinder;
    private final int minGrassCount;
    private final int minHerbivoreCount;

    public TurnActions(WorldMap worldMap, PathFinder pathFinder) {
        this.worldMap = worldMap;
        this.pathFinder = pathFinder;
        minGrassCount = worldMap.getEntitiesByType(Grass.class).size();
        minHerbivoreCount = worldMap.getEntitiesByType(Herbivore.class).size();
    }

    @Override
    public void perform() {
        moveCreatures();
        generateNewGrassIfNeeded();
        generateNewHerbivoreIfNeeded();
        WorldMapPrintTool.printWorldMap(worldMap);
    }

    private void moveCreatures(){
        List<Creature> creatures = worldMap.getAllCreatures();
        for (Creature creature : creatures) {
            Position currentPos = worldMap.getPositionOf(creature);
            if (currentPos == null) continue;
            creature.makeMove(worldMap, pathFinder);
        }
    }

    private void generateNewGrassIfNeeded() {
        List<Grass> grassList = worldMap.getEntitiesByType(Grass.class);
        if (grassList.size() < minGrassCount) {
            Position newPos = FindEmptyPositionTool.findRandomPosition(worldMap);
            worldMap.putEntity(newPos, new Grass());
            System.out.printf(Constants.SPAWN_ENTITY, Grass.class.getSimpleName(), newPos);
        }
    }

    private void generateNewHerbivoreIfNeeded() {
        List<Herbivore> herbivoreList = worldMap.getEntitiesByType(Herbivore.class);
        if (herbivoreList.size() < minHerbivoreCount) {
            Position newPos = FindEmptyPositionTool.findRandomPosition(worldMap);
            worldMap.putEntity(newPos, new Herbivore());
            System.out.printf(Constants.SPAWN_ENTITY, Herbivore.class.getSimpleName(), newPos);
        }
    }
}
