package main.java.com.mikitarudy.simulation.tool;

import main.java.com.mikitarudy.simulation.action.InitActions;
import main.java.com.mikitarudy.simulation.entity.*;
import main.java.com.mikitarudy.simulation.map.WorldMap;

import java.util.function.Supplier;

public class WorldMapFactory {

    public static WorldMap createMap(
            int len,
            int height,
            int herbivoreCount,
            int predatorCount,
            int treeCount,
            int grassCount,
            int rockCount
    ) {
        WorldMap worldMap = new WorldMap(len, height);
        spawnEntity(worldMap, Herbivore::new, herbivoreCount);
        spawnEntity(worldMap, Predator::new, predatorCount);
        spawnEntity(worldMap, Tree::new, treeCount);
        spawnEntity(worldMap, Grass::new, grassCount);
        spawnEntity(worldMap, Rock::new, rockCount);
        return worldMap;
    }

    private static void spawnEntity(WorldMap worldMap, Supplier<Entity> entitySupplier, int count) {
        InitActions action = new InitActions(worldMap, entitySupplier, count);
        action.perform();
    }
}
