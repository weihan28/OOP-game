package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.factories.PurchasableFactory;
import game.items.actions.PurchaseAction;
import game.items.actions.SellAction;
import game.items.actions.Sellable;

import java.util.ArrayList;

/**
 * This class describes the humanoid vendor, on the static factory selling item area

 */
public class Vendor extends Ground {
    private final ArrayList<Sellable> vendorBuying;
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Vendor(char displayChar, ArrayList<Sellable> vendorBuying) {
        super(displayChar);
        this.vendorBuying = vendorBuying;
    }

    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        for (Sellable sellable: vendorBuying) {
            if (actor.getItemInventory().contains(sellable)) {
                actions.add(new SellAction(sellable));
            }
        }
        return actions;
    }


}
