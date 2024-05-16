package game.items.scraps;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * A class that represents a Purchase Action in the game.
 */
public class MonologueAction extends Action {
    private final String monologue;

    /**
     * Constructor of a monologue action.
     * @param monologue the monologue that will be spoken.
     */
    public MonologueAction(String monologue) {
        this.monologue = monologue;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return monologue;
    }

    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s talks to %s", actor, monologuable);
    }
}
