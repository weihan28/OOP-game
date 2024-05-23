package game.grounds.trees;

import edu.monash.fit2099.engine.positions.Location;
import game.grounds.groundBehaviours.GrowBehaviour;
import game.items.fruits.Fruit;
import game.items.fruits.SmallFruit;

/**
 * A concrete class representing a sapling inheritree.
 */
public class SproutInheritree extends Inheritree{
    int counter;

    public SproutInheritree() {
        super(',', 0);
        this.counter = 0;
        this.behaviours.put(10, new GrowBehaviour(3, new SaplingInheritree()));
    }

    /**
     * Creates a small fruit
     *
     * @see Inheritree#createFruit()
     * @return a Small Fruit object.
     */
    @Override
    public Fruit createFruit() {
        return new SmallFruit();
    }
}