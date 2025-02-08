package main.java.com.mikitarudy.simulation.simulation;

import main.java.com.mikitarudy.simulation.action.Action;
import main.java.com.mikitarudy.simulation.action.TurnActions;
import main.java.com.mikitarudy.simulation.map.WorldMap;
import main.java.com.mikitarudy.simulation.pathfinding.PathFinder;
import main.java.com.mikitarudy.simulation.tool.WorldMapPrintTool;

import java.util.Scanner;

public class Simulation {
    private final WorldMap worldMap;
    private final Action turnAction;
    public static int countOfMoves = 0;
    private final Object lock = new Object();
    private boolean pause = true;
    private final Scanner scanner = new Scanner(System.in);

    public Simulation(WorldMap worldMap) {
        this.worldMap = worldMap;
        this.turnAction = new TurnActions(worldMap, new PathFinder(worldMap));
    }

    private void nextMove() {
        turnAction.perform();
        WorldMapPrintTool.printWorldMap(worldMap);
    }
}
