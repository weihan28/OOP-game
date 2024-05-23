package game.grounds.trees;

import game.grounds.groundBehaviours.GrowGroundBehaviour;
import game.items.fruits.Fruit;
import game.items.fruits.SmallFruit;

/**
 * A concrete class representing a sapling inheritree.
 */
public class SproutInheritree extends Inheritree{
    private int tickToGrow = 3;

    public SproutInheritree() {
        super(',');
        this.behaviours.put(1, new GrowGroundBehaviour(tickToGrow, new SaplingInheritree()));
    }
}