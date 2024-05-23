package game.grounds.trees;

import edu.monash.fit2099.engine.positions.Location;
import game.grounds.groundBehaviours.GrowBehaviour;
import game.items.fruits.Fruit;
import game.items.fruits.SmallFruit;

/**
 * A concrete class representing a sapling inheritree.
 */
public class SaplingInheritree extends Inheritree{
    int counter;

    public SaplingInheritree() {
        super('t', 30);
        this.counter = 0;
        this.behaviours.put(10, new GrowBehaviour(6, new YoungInheritree()));
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

