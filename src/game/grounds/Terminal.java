package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.factories.PurchasableFactory;
import game.items.actions.PurchaseAction;
import game.maps.Moon;
import game.maps.TravelAction;

import java.util.ArrayList;

/**
 * A class that represents the Terminal in the game.
 */
public class Terminal extends Ground {

    private final ArrayList<PurchasableFactory> purchasableFactories;
    private Moon[] moons;

    public Terminal(ArrayList<PurchasableFactory> purchasableFactories, Moon[] moons) {
        super('=');
        this.purchasableFactories = purchasableFactories;
        this.moons = moons;
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
        for (Moon moon: moons){
            if (location.map() != moon) {
                actions.add(new TravelAction(moon));
            }
        }
        return actions;
    }
}
