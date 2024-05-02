package game.spawners;

import edu.monash.fit2099.engine.positions.Location;

/**
 * Interface for Spawners that spawns a game entity in a location.
 */
public interface Spawner {
    /**
     * Method that handles the spawning of entities on a location.
     * @param location The location that the spawning is going to execute.
     */
    public void spawn(Location location);
}
