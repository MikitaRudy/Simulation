package main.java.com.mikitarudy.simulation.entity;

import main.java.com.mikitarudy.simulation.map.Position;
import main.java.com.mikitarudy.simulation.map.WorldMap;
import main.java.com.mikitarudy.simulation.tool.Constants;

public class Herbivore extends Creature{
    public Herbivore() {
        super(Constants.HERBIVORE);
    }

    @Override
    protected Class<? extends Entity> getTargetType() {
        return Grass.class;
    }

    @Override
    protected void handleTargetReached(WorldMap map, Position targetPos) {
        map.removeEntity(targetPos);
    }
}
