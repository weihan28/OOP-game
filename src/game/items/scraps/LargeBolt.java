package game.items.scraps;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;
import game.items.actions.SellAction;
import game.items.actions.Sellable;

/**
 * Class representing a LargeBolt scrap.
 */
public class LargeBolt extends Item implements Sellable {
    public LargeBolt() {
        super("Large bolt", '+', true);
    }


    /**
     * Returns the sell logic for selling a LargeBolt
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
     * AllowableActions method must be overridden to allow the actor to sell the item.
     * @param otherActor the other actor
     * @param location the location of the other actor
     * @return
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.SELLABLE_TOWARDS)) {
            actions.add(new SellAction(this, otherActor));
        }
        return actions;
    }

    /**
     * Helper getter method defined by interface to get sellvalue of bolt
     * @return
     */
    @Override
    public int getSellValue() {
        return 25;
    }
}
