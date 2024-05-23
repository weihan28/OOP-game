package game.grounds.trees;

import edu.monash.fit2099.engine.positions.Location;
import game.grounds.groundBehaviours.SpawnFruitGroundBehaviour;
import game.items.fruitFactories.LargeFruitFactory;
import game.items.fruits.Fruit;
import game.items.fruits.LargeFruit;

/**
 * A concrete class representing a mature inheritree.
 */
public class MatureInheritree extends Inheritree {
    public MatureInheritree() {
        super('T');
        this.behaviours.put(10, new SpawnFruitGroundBehaviour(20, new LargeFruitFactory()));
    }

    /**
     * Mature Inheritree can also experience the joy of time.
     *
     * @see Inheritree#tick(Location)
     * @param location The location of the Inheritree
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
    }
}
