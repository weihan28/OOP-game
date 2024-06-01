package game.items.fruits;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.actions.Sellable;

/**
 * Class representing the Large variation of fruit.
 */
public class LargeFruit extends Fruit implements Sellable {
    public LargeFruit() {
        super("Large Fruit", 'O', 2);
    }

    @Override
    public String sellFrom(Actor actor, GameMap map) {
        actor.removeItemFromInventory(this);
        actor.addBalance(this.getSellValue());
        return String.format("Successfully sold %s for %d credits.", this, getSellValue());
    }

    @Override
    public int getSellValue() {
        return 30;
    }
}
