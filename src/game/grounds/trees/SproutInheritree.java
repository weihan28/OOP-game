package game.grounds.trees;

import game.grounds.groundBehaviours.GrowGroundBehaviour;
import game.items.fruits.Fruit;
import game.items.fruits.SmallFruit;

/**
 * A concrete class representing a sapling inheritree.
 */
public class SproutInheritree extends Inheritree{
    int counter;

    public SproutInheritree() {
        super(',');
        this.counter = 0;
        this.behaviours.put(10, new GrowGroundBehaviour(3, new SaplingInheritree()));
    }
}