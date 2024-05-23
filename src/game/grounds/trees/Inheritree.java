package game.grounds.trees;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.grounds.groundBehaviours.GroundBehaviour;
import game.grounds.groundBehaviours.GrowBehaviour;
import game.items.fruits.Fruit;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * A abstract class representing the inheritree.
 */
public abstract class Inheritree extends Ground{
    protected Map<Integer, GrowBehaviour> behaviours = new TreeMap<>();

    private final Random random = new Random();
    private int spawnChance;

    public Inheritree(char displayChar, int spawnChance) {
        super(displayChar);
        this.spawnChance = spawnChance;
    }

    /**
     * Inheritree can also experience the joy of time.
     *
     * @see Ground#tick(Location)
     * @param location The location of the Inheritree
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        if(random.nextInt(100) <= spawnChance){
            spawnFruit(location);
        }
        for (GroundBehaviour behaviour : behaviours.values()) {
            behaviour.doAction(this, location);
        }
    }

    /**
     * Spawns a fruit at a nearby exit from the location
     *
     * @param location
     */
    private void spawnFruit(Location location){
        List<Exit> exits = location.getExits();
        Exit exitToSpawn = exits.get(random.nextInt(exits.size()));
        exitToSpawn.getDestination().addItem(createFruit());
    }

    /**
     * Abstract method for creating a fruit that is from the tree.
     *
     * @return a Fruit object.
     */
    protected abstract Fruit createFruit();

    /**
     * A string representation for the Inheritree.
     * @return the name of the tree.
     */
    public String toString() {
        return "Inheritree";
    }
}

