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
    private int tickToGrow = 6;
    private int spawnChance = 30;

    public SaplingInheritree() {
        super('t');
        this.behaviours.put(1, new GrowGroundBehaviour(tickToGrow, new YoungInheritree()));
        this.behaviours.put(2, new SpawnFruitGroundBehaviour(spawnChance, new SmallFruitFactory()));
    }
}

