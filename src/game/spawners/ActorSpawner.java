package game.spawners;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.factories.ActorFactory;

import java.util.Random;

/**
 * A class that represents a spawner class that spawns Actors.
 */
public class ActorSpawner implements Spawner {
    private double spawnChance;
    private final Random random = new Random();
    private ActorFactory actorFactory;

    /**
     * Constructor initialise the ActorSpawner instance.
     * @param actorFactory Actor Factory for creating the actors that are spawned in the area.
     * @param spawnChance The chance of the actor spawning.
     */
    public ActorSpawner(ActorFactory actorFactory, double spawnChance) {
        this.actorFactory = actorFactory;
        this.spawnChance = spawnChance;
    }

    /**
     * Sets a new SpawnChance.
     * @param spawnChance a double from 0 to 100 representing the spawn chance.
     */
    public void setSpawnChance(double spawnChance) {
        this.spawnChance = spawnChance;
    }

    /**
     * Sets a new Actor Factory to change the actor that will be spawned.
     * @param actorFactory the factory for creating the new actors.
     */
    public void setActorFactory(ActorFactory actorFactory) {
        this.actorFactory = actorFactory;
    }

    /**
     * Spawns an actor in the surrounding area with a given spawn chance.
     * @param location The location that the spawning is going to execute.
     */
    @Override
    public void spawn(Location location) {
        if(random.nextInt(100) <= spawnChance){
            for(Exit exit : location.getExits()){
                if(!exit.getDestination().containsAnActor()){
                    exit.getDestination().addActor(actorFactory.createActor());
                    break;
                }
            }
        }
    }
}
