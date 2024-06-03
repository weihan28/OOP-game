package game.maps;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import java.util.List;

/**
 * Abstract class that for different moons.
 */
public abstract class Moon extends GameMap {
    private static final int DEFAULT_PLAYER_SPAWN_X = 0;
    private static final int DEFAULT_PLAYER_SPAWN_Y = 0;

    public Moon(FancyGroundFactory groundFactory, List<String> mapString){
        super(groundFactory, mapString);
    }

    /**
     * Gets the location of where to spawn the player.
     *
     * @return The location to spawn the player on the map.
     */
    public Location getPlayerSpawn(){
        return this.at(DEFAULT_PLAYER_SPAWN_X, DEFAULT_PLAYER_SPAWN_Y);
    }
}
