package game.items.actions;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;

/**
 * An interface for monologuable objects.
 */
public interface Monologuable {

    /**
     * Called when an actor talks to the object.
     * @param actor The actor that is talking to the object.
     * @return An ActionList of possible MonologueActions
     */
    public ActionList getMonologueOptions(Actor actor);
}
