package main.java.com.mikitarudy.simulation;

import main.java.com.mikitarudy.simulation.map.WorldMap;
import main.java.com.mikitarudy.simulation.tool.WorldMapFactory;
import main.java.com.mikitarudy.simulation.tool.WorldMapPrintTool;

public class Main {
    public static void main(String[] args) {
        WorldMap map = WorldMapFactory.createMap(
                10,
                15,
                4,
                2,
                6,
                5,
                6);
        WorldMapPrintTool.printWorldMap(map);
    }
}
