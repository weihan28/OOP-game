package game.items.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

import java.util.Random;

/**
 * A class that represents an AI Device in the game known as Astley.
 */
public class AIDevice extends Item implements Purchasable, Monologuable{
    private final int cost = 50;

    public AIDevice() {
        super("Astley", 'z', true);
    }

    /**
     * Called when an actor is purchasing the item.
     * @param actor The actor that is purchasing the object.
     * @return the result string of the purchase.
     */
    @Override
    public String purchaseBy(Actor actor) {
        actor.addItemToInventory(this);
        return String.format("%s successfully purchased %s", actor, this);
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public ActionList getMonologue(Actor actor) {
        return null;
    }
}
