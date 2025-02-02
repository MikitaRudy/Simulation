package main.java.com.mikitarudy.simulation.tool;

import main.java.com.mikitarudy.simulation.map.Position;
import main.java.com.mikitarudy.simulation.map.WorldMap;

public class WorldMapPrintTool {
    public static void printWorldMap(WorldMap worldMap) {
        for (int x = 0; x < worldMap.width; x++) {
            for (int y = 0; y < worldMap.height; y++) {
                Position position = new Position(x, y);
                if (worldMap.isPositionEmpty(position)) {
                    System.out.print("\uD83C\uDFFD" + " ");
                }
                else {
                    System.out.print(worldMap.getEntity(position).getEmoji() + " ");
                }
            }
            System.out.println();
        }
    }
}
