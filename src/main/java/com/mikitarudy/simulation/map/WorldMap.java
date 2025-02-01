package main.java.com.mikitarudy.simulation.map;

import main.java.com.mikitarudy.simulation.entity.Entity;
import java.util.*;

public class WorldMap {
    private final int width;
    private final int height;
    private Map<Position, Entity> entities = new HashMap<>();

    public WorldMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Entity getEntity(Position position) {
        return entities.get(position);
    }

    public boolean isPositionEmpty(Position position){
        return !entities.containsKey(position);
    }

    public void putEntity(Position position, Entity entity){
        entities.put(position, entity);
    }
}
