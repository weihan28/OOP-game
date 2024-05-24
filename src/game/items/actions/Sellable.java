package game.items.actions;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * An interface for purchasable objects.
 */
public interface Sellable {
    /**
     * Called when an actor sells the object.
     * @param actor The actor that is selling the object.
     * @return The description of the selling outcome.
     */
    public String SellFrom(Actor actor);

}
