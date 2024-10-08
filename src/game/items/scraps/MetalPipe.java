package game.items.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.Status;
import game.actors.actions.AttackAction;
import game.items.actions.SellAction;
import game.items.actions.Sellable;

/**
 * Class representing a Metal Pipe special scrap.
 */
public class MetalPipe extends WeaponItem implements Sellable {
    public MetalPipe() {
        super("Metal Pipe", '!', 1, "hits", 20);
    }

    @Override
    public String sellFrom(Actor actor, GameMap map, Actor buyer) {
        actor.removeItemFromInventory(this);
        actor.addBalance(getSellValue());
        return String.format("Successfully sold %s for %d credits.", this, getSellValue());
    }

    /**
     * List of allowable actions that the item allows its owner do to other actor.
     * @see WeaponItem#allowableActions(Actor, Location)
     * @param otherActor the other actor
     * @param location the location of the other actor
     * @return an unmodifiable list of Actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_PLAYER)) {
            actions.add(new AttackAction(otherActor, location.toString(), this));
        }
        if (otherActor.hasCapability(Status.SELLABLE_TOWARDS)) {
            actions.add(new SellAction(this, otherActor));
        }
        return actions;
    }

    /**
     * Getter method to get the value of a sellable item when sold
     * @return
     */
    @Override
    public int getSellValue() {
        return 35;
    }
}
