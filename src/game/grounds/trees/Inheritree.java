package game.grounds.trees;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.grounds.groundBehaviours.GroundBehaviour;
import java.util.Map;
import java.util.TreeMap;

/**
 * A abstract class representing the Inheritree.
 */
public abstract class Inheritree extends Ground{
    protected Map<Integer, GroundBehaviour> behaviours = new TreeMap<>();

    public Inheritree(char displayChar) {
        super(displayChar);
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

        for (GroundBehaviour behaviour : behaviours.values()) {
            behaviour.doAction(this, location);
        }
    }

     /**
     * A string representation for the Inheritree.
     * @return the name of the tree.
     */
    public String toString() {
        return "Inheritree";
    }
}

