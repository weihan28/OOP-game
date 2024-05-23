package game.grounds.trees;

import edu.monash.fit2099.engine.positions.Location;
import game.items.fruits.Fruit;
import game.items.fruits.SmallFruit;

public class YoungInheritree extends Inheritree {

    int counter;

    public YoungInheritree() {
        super('y', 0);
        this.counter = 0;
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
        counter++;
        if(counter % 5 == 0){
            location.setGround(new MatureInheritree());
        }
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
