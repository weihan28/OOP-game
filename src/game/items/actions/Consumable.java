package game.items.actions;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * Interface for game entities that can be consumed.
 */
public interface Consumable {

    /**
     * Lets the consumable be consumed by a actor.
     *
     * @param actor The actor that will consume the Item.
     * @return a description of what happened that can be displayed to the user.
     */
    public String consumedBy(Actor actor);
}
