package game.items.actions;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * An interface for purchasable objects.
 */
public interface Purchasable {
    /**
     * Called when an actor purchases the object.
     * @param actor The actor that is purchasing the object.
     * @return The description of the purchase result.
     */
    public String purchaseBy(Actor actor);

    /**
     * Get the price of the object.
     * @return the price of the object.
     */
    public int getCost();
}
