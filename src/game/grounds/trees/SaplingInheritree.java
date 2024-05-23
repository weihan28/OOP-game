package game.grounds.trees;

import game.grounds.groundBehaviours.GrowGroundBehaviour;
import game.grounds.groundBehaviours.SpawnFruitGroundBehaviour;
import game.items.fruitFactories.SmallFruitFactory;
import game.items.fruits.Fruit;
import game.items.fruits.SmallFruit;

/**
 * A concrete class representing a sapling inheritree.
 */
public class SaplingInheritree extends Inheritree{
    private int counter;

    public SaplingInheritree() {
        super('t');
        this.counter = 0;
        this.behaviours.put(10, new GrowGroundBehaviour(6, new YoungInheritree()));
        this.behaviours.put(30, new SpawnFruitGroundBehaviour(30, new SmallFruitFactory()));
    }
}

