package main.java.com.mikitarudy.simulation.tool;

import main.java.com.mikitarudy.simulation.map.*;

import java.util.Random;

public class FindEmptyPositionTool {

    public static Position findRandomPosition (WorldMap worldMap){
        Random random = new Random();
        while(true){
            int x = random.nextInt(worldMap.width);
            int y = random.nextInt(worldMap.height);
            Position position = new Position(x, y);
            if (worldMap.isPositionEmpty(position)){
                return position;
            }
        }
    }
}
