package main.java.com.mikitarudy.simulation.action;

import main.java.com.mikitarudy.simulation.entity.*;
import main.java.com.mikitarudy.simulation.map.*;
import main.java.com.mikitarudy.simulation.tool.FindEmptyPositionTool;

import java.util.function.Supplier;

public class InitActions extends Action {
    private final WorldMap worldMap;
    private final Supplier<Entity> entitySupplier;
    private final int count;

    public InitActions(WorldMap worldMap, Supplier<Entity> entitySupplier, int count) {
        this.worldMap = worldMap;
        this.entitySupplier = entitySupplier;
        this.count = count;
    }

    @Override
    public void perform() {
        for (int i = 0; i < count; i++) {
            Position position = FindEmptyPositionTool.findRandomPosition(worldMap);
            worldMap.putEntity(position, entitySupplier.get());
        }
    }
}
