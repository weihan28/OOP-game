package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.factories.PurchasableFactory;
import game.items.actions.PurchaseAction;

import java.util.ArrayList;

/**
 * A class that represents the Terminal in the game.
 */
public class Terminal extends Ground {

    private final ArrayList<PurchasableFactory> purchasableFactories;

    public Terminal(ArrayList<PurchasableFactory> purchasableFactories) {
        super('=');
        this.purchasableFactories = purchasableFactories;
    }

    /**
     * Get all the allowed actions for interacting with the terminal.
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        for (PurchasableFactory purchasableFactory: purchasableFactories) {
            actions.add(new PurchaseAction(purchasableFactory.createPurchasable()));
        }
        return actions;
    }
}
