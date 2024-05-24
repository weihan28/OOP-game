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
    private int spawnChance = 20;

    public MatureInheritree() {
        super('T');
        this.behaviours.put(1, new SpawnFruitGroundBehaviour(spawnChance, new LargeFruitFactory()));
    }
}
