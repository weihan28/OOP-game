package game.items.fruits;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;
import game.items.actions.SellAction;
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

    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = super.allowableActions(otherActor);
        if (otherActor.hasCapability(Status.SELLABLE_TOWARDS)) {
            actions.add(new SellAction(this));
        }
        return actions;
    }
}
