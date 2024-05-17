package game.grounds.trees;

import edu.monash.fit2099.engine.positions.Location;
import game.items.fruits.Fruit;
import game.items.fruits.LargeFruit;

/**
 * A concrete class representing a mature inheritree.
 */
public class MatureInheritree extends Inheritree {
    public MatureInheritree() {
        super('T', 20);
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

    /**
     * creates a large fruit.
     *
     * @see Inheritree#createFruit()
     * @return a Large Fruit object.
     */
    @Override
    public Fruit createFruit() {
        return new LargeFruit();
    }
}
