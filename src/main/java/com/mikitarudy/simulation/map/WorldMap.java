package main.java.com.mikitarudy.simulation.map;

import main.java.com.mikitarudy.simulation.entity.Creature;
import main.java.com.mikitarudy.simulation.entity.Entity;
import java.util.*;
import java.util.stream.Collectors;

public class WorldMap {
    public final int width;
    public final int height;
    private Map<Position, Entity> entities = new HashMap<>();

    public WorldMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Entity getEntity(Position position) {
        return entities.get(position);
    }

    public boolean isPositionEmpty(Position position){
        return !entities.containsKey(position);
    }

    public boolean isPositionValid(Position position) {
        return position.getX() >= 0 && position.getX() < width &&
                position.getY() >= 0 && position.getY() < height;
    }

    public void putEntity(Position position, Entity entity){
        if (isPositionEmpty(position) && isPositionEmpty(position)){
            entities.put(position, entity);
        }
    }

    public void removeEntity(Position position) {
        entities.remove(position);
    }

    public void moveEntity(Position oldPos, Position newPos) {
        if (isPositionValid(newPos) && isPositionEmpty(newPos)) {
            Entity entity = entities.get(oldPos);
            if (entity != null) {
                entities.remove(oldPos);
                entities.put(newPos, entity);
            }
        }
    }

    public <T extends Entity> List<T> getEntitiesByType(Class<T> type) {
        return entities.values().stream()
                .filter(type::isInstance)
                .map(type::cast)
                .collect(Collectors.toList());
    }

    public List<Creature> getAllCreatures() {
        return getEntitiesByType(Creature.class);
    }

    public Position getPositionOf(Entity entity) {
        return entities.entrySet().stream()
                .filter(entry -> entry.getValue().equals(entity))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }
}
