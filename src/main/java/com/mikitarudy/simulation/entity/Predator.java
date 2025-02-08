package main.java.com.mikitarudy.simulation.entity;

import main.java.com.mikitarudy.simulation.map.Position;
import main.java.com.mikitarudy.simulation.map.WorldMap;
import main.java.com.mikitarudy.simulation.tool.Constants;

public class Predator extends Creature{
    public Predator() {
        super(Constants.PREDATOR);
    }

    @Override
    protected Class<? extends Entity> getTargetType() {
        return Herbivore.class;
    }

    @Override
    protected void handleTargetReached(WorldMap map, Position targetPos) {
        map.removeEntity(targetPos);
    }
}
