package main.java.com.mikitarudy.simulation;

import main.java.com.mikitarudy.simulation.map.WorldMap;
import main.java.com.mikitarudy.simulation.simulation.Simulation;
import main.java.com.mikitarudy.simulation.tool.Constants;
import main.java.com.mikitarudy.simulation.tool.MenuPrintTool;
import main.java.com.mikitarudy.simulation.tool.WorldMapFactory;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuPrintTool.startMenu();
        while (true) {
            switch (scanner.nextLine()) {
                case Constants.ONE -> start();
                case Constants.ZERO -> System.exit(0);
                default -> System.out.println(Constants.INCORRECT_INPUT);
            }
        }
    }

    private static void start() {
        WorldMap worldMap = WorldMapFactory.createMap(
                5,
                5,
                2,
                1,
                2,
                3,
                2);
        Simulation simulation = new Simulation(worldMap);
        simulation.startSimulation();
    }
}
