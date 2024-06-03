package game.items.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.items.actions.Purchasable;
import game.maps.TeleportAction;

/**
 * A class that represents a Theseus in the game.
 **/
public class Theseus extends Item implements Purchasable {

    private final int cost;

    public Theseus(){
        super("Theseus", '^', true);
        cost = 100;
    }

    @Override
    public String purchaseBy(Actor actor) {
        actor.addItemToInventory(this);
        return String.format("%s successfully purchased %s", actor, this);
    }

    @Override
    public int getCost() { return cost; }

    /**
     * List of allowable actions that can be performed on the item when it is on the ground
     * Allows the Intern to select the option to teleport.
     *
     * @param location the location of the ground on which the item lies
     * @return an unmodifiable list of Actions
     */
    @Override
    public ActionList allowableActions(Location location) {
        ActionList actions = super.allowableActions(location);
        actions.add(new TeleportAction());
        return actions;
    }
}
