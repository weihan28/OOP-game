package game.items.fruits;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Status;
import game.items.actions.Sellable;

/**
 * Class representing the Large variation of fruit.
 */
public class LargeFruit extends Fruit implements Sellable {
    public LargeFruit() {
        super("Large Fruit", 'O', 2);
        this.addCapability(Status.SELLABLE);
    }

    @Override
    public String SellFrom(Actor actor, GameMap map) {
        actor.removeItemFromInventory(this);
        actor.addBalance(this.getSellValue());
        return "Successfully sold LargeFruit  for " + this.getSellValue() + " credits.";
    }

    @Override
    public int getSellValue() {
        return 30;
    }
}
