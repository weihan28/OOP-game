package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.factories.HuntsmanSpiderFactory;
import game.spawners.ActorSpawner;

/**
 * A class that represents a crater.
 */
public class Crater extends Ground {
    private ActorSpawner spawner;

    public Crater() {
        super('u');
        this.spawner = new ActorSpawner(new HuntsmanSpiderFactory(), 5);
    }

    /**
     * Crater can also experience the joy of time.
     * Spawns a new actor in its surroundings.
     *
     * @param location The location of the Crater
     */
    @Override
    public void tick(Location location) {
        this.spawner.spawn(location);
    }
}