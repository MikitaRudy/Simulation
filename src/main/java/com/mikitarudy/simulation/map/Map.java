package main.java.com.mikitarudy.simulation.map;

import main.java.com.mikitarudy.simulation.entity.Entity;
import java.util.*;

public class Map {
    private final int width;
    private final int height;
    private HashMap<Position, Entity> entities = new HashMap<>();

    public Map(int width, int height) {
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
