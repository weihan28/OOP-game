package game.grounds.trees;

import edu.monash.fit2099.engine.positions.Location;
import game.grounds.groundBehaviours.GrowGroundBehaviour;
import game.grounds.groundBehaviours.SpawnFruitGroundBehaviour;
import game.items.fruits.Fruit;
import game.items.fruits.SmallFruit;

public class YoungInheritree extends Inheritree {

    int counter;

    public YoungInheritree() {
        super('y');
        this.counter = 0;
        this.behaviours.put(10, new GrowGroundBehaviour(5, new MatureInheritree()));

    }

    /**
     * Sapling Inheritree can also experience the joy of time.
     *
     * @see Inheritree#tick(Location)
     * @param location The location of the Inheritree
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
    }
}
