package main.java.com.mikitarudy.simulation;

import main.java.com.mikitarudy.simulation.action.TurnActions;
import main.java.com.mikitarudy.simulation.map.WorldMap;
import main.java.com.mikitarudy.simulation.pathfinding.PathFinder;
import main.java.com.mikitarudy.simulation.tool.MenuPrintTool;
import main.java.com.mikitarudy.simulation.tool.WorldMapFactory;
import main.java.com.mikitarudy.simulation.tool.WorldMapPrintTool;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WorldMap worldMap = WorldMapFactory.createMap(
                5,
                5,
                2,
                1,
                2,
                3,
                2);

        MenuPrintTool.startMenu();
        while (true) {
            switch (scanner.nextLine()) {
                case "1" -> System.out.println();
                case "0" -> System.exit(0);
                default -> System.out.println("Некорректный ввод! Введите 1 или 0");
            }
        }

        /*TurnActions actions = new TurnActions(map, new PathFinder(map));
        WorldMapPrintTool.printWorldMap(map);
        System.out.println();

        for (int i = 0; i < 10; i++) {
            System.out.println("Ход " + (i + 1) + " завершён.");
            actions.perform();
            System.out.println();
        }*/
    }
}
