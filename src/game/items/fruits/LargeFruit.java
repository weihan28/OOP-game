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

    /**
     * Returns the sell logic for selling a LargeFruit
     * @param actor The actor that is selling the object.
     * @param map
     * @param buyer
     * @return
     */
    @Override
    public String sellFrom(Actor actor, GameMap map, Actor buyer) {
        actor.removeItemFromInventory(this);
        actor.addBalance(this.getSellValue());
        return String.format("Successfully sold %s for %d credits.", this, getSellValue());
    }

    /**
     * Helper getter method defined by interface to get sellvalue of fruit
     * @return
     */
    @Override
    public int getSellValue() {
        return 30;
    }

    /**
     * Returns the allowable actions for the LargeFruit
     * @param otherActor the other actor
     * @param location the location of the other actor
     * @return
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = super.allowableActions(otherActor);
        if (otherActor.hasCapability(Status.SELLABLE_TOWARDS)) {
            actions.add(new SellAction(this, otherActor));
        }
        return actions;
    }
}
