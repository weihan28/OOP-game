package game.items.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.actions.AttackAction;
import game.items.actions.Sellable;

/**
 * Class representing a Metal Pipe special scrap.
 */
public class MetalPipe extends WeaponItem implements Sellable {
    public MetalPipe() {
        super("Metal Pipe", '!', 1, "hits", 20);
    }

    /**
     * List of allowable actions that the item allows its owner do to other actor.
     *
     * @see WeaponItem#allowableActions(Actor, Location)
     * @param otherActor the other actor
     * @param location the location of the other actor
     * @return an unmodifiable list of Actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = new ActionList();
        actions.add(new AttackAction(otherActor, location.toString(), this));
        return actions;
    }

    @Override
    public String SellFrom(Actor actor) {
        actor.removeItemFromInventory(this);
        actor.addBalance(this.getSellValue());
        return "Successfully sold Metal Pipe for " + this.getSellValue() + " credits.";
    }

    @Override
    public int getSellValue() {
        return 35; // 35 credits for a Metal Pipe when sold
    }
}
