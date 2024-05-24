package game.maps;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.grounds.Dirt;
import game.grounds.Floor;
import game.grounds.Puddle;
import game.grounds.Wall;

import java.util.Arrays;
import java.util.List;

public class FactoryParkingLot extends Moon {
    public final static List<String> mapString = Arrays.asList(
            ".......",
            ".#####.",
            ".#___#.",
            ".#___#.",
            ".##_##.",
            ".......",
            ".......",
            ".......",
            ".......",
            ".......");
    private final static int[] playerSpawn = {3, 3};

    private final static FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor());

    public FactoryParkingLot(){
        super(groundFactory, mapString);
    }

    public Location getPlayerSpawn(){
        return this.at(playerSpawn[0], playerSpawn[1]);
    }
}
