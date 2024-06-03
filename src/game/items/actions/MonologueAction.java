package game.items.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * A class that represents a Monologue Action in the game.
 */
public class MonologueAction extends Action {
    private final String speaker;
    private final String monologue;

    public MonologueAction(String speaker, String monologue) {
        this.speaker = speaker;
        this.monologue = monologue;
    }

    /**
     *  Allow the entity to monologue
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return string representing the monologue
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return String.format("%s: %s", speaker, monologue);
    }

    /**
     * Describe what action will be performed if this Action is chosen in the menu.
     * @param actor The actor performing the action.
     * @return  string representing a potential monologue.
     */
    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s talks to %s", actor, speaker);
    }
}
