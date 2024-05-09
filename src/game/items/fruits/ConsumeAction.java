package game.items.fruits;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * An action class for an actor to consume a consumable.
 */
public class ConsumeAction extends Action {
    private final Consumable consumable;

    public ConsumeAction(Consumable consumable) {
        this.consumable = consumable;
    }

    /**
     * Allow the Actor to consume the consumable.
     *
     * Overrides Action.execute()
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a String, e.g. "Intern (4/4) consumes Large Fruit and Large Fruit heals Intern for 2 health."
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String description = consumable.consumedBy(actor);
        return String.format("%s consumed %s and %s.", actor, consumable, description);
    }

    /**
     * Describe what action will be performed if this Action is chosen in the menu.
     * @param actor The actor performing the action.
     * @return a String, e.g. "Intern (4/4) consumes Large Fruit."
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + consumable;
    }
}
