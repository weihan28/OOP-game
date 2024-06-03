package game.maps;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.Location;
import game.grounds.Dirt;
import game.grounds.Floor;
import game.grounds.Wall;

import java.util.Arrays;
import java.util.List;

/**
 * A class that represents the Factory Parking Lot in the game.
 */
public class FactoryParkingLot extends Moon {
    public static List<String> mapString = Arrays.asList(
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
    private static final FancyGroundFactory GROUND_FACTORY = new FancyGroundFactory(new Dirt(), new Wall(), new Floor());
    private static final int PLAYER_SPAWN_X = 3;
    private static final int PLAYER_SPAWN_Y = 3;


    public FactoryParkingLot(){
        super(GROUND_FACTORY, mapString);
    }

    @Override
    public Location getPlayerSpawn(){
        return this.at(PLAYER_SPAWN_X,PLAYER_SPAWN_Y);
    }
    @Override
    public String toString() {
        return "FactoryParkingLot";
    }
}
