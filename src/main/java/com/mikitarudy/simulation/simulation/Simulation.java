package main.java.com.mikitarudy.simulation.simulation;

import main.java.com.mikitarudy.simulation.action.Action;
import main.java.com.mikitarudy.simulation.action.TurnActions;
import main.java.com.mikitarudy.simulation.map.WorldMap;
import main.java.com.mikitarudy.simulation.pathfinding.PathFinder;
import main.java.com.mikitarudy.simulation.tool.Constants;
import main.java.com.mikitarudy.simulation.tool.MenuPrintTool;
import main.java.com.mikitarudy.simulation.tool.WorldMapPrintTool;

import java.util.Scanner;

public class Simulation {
    private final WorldMap worldMap;
    private final Action turnAction;
    private final Object lock = new Object();
    private boolean pause = true;
    private final Scanner scanner = new Scanner(System.in);

    public Simulation(WorldMap worldMap) {
        this.worldMap = worldMap;
        this.turnAction = new TurnActions(worldMap, new PathFinder(worldMap));
    }

    private void nextTurn() {
        turnAction.perform();
        WorldMapPrintTool.printWorldMap(worldMap);
        System.out.println();
    }

     public void startSimulation() {
         Thread thread = createThreadForSimulation();
         System.out.println(Constants.SIMULATION_START);
         WorldMapPrintTool.printWorldMap(worldMap);
         thread.start();
         while (true) {
             printMenu();
         }
     }

    private Thread createThreadForSimulation() {
        return new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (pause) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                MenuPrintTool.infinityMenu();
                nextTurn();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void printMenu() {
        if (pause) {
            MenuPrintTool.pauseMenu();
            String userInput = scanner.nextLine();
            switch (userInput) {
                case Constants.ONE -> continueSimulation();
                case Constants.TWO -> nextTurn();
                case Constants.ZERO -> System.exit(0);
                default -> System.out.println(Constants.INCORRECT_INPUT);
            }
        } else {
            if (scanner.nextLine().equals(Constants.ONE)) {
                pauseSimulation();
            } else {
                System.out.println(Constants.INCORRECT_INPUT);
            }
        }
    }

    private void pauseSimulation() {
        pause = true;
    }

    private void continueSimulation() {
        pause = false;
        synchronized (lock) {
            lock.notify();
        }
    }
}
