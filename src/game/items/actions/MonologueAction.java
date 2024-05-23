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

    /**
     * Constructor of a monologue action.
     * @param speaker the speaker of the monologue
     * @param monologue the monologue that will be spoken.
     */
    public MonologueAction(String speaker, String monologue) {
        this.speaker = speaker;
        this.monologue = monologue;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return String.format("%s: %s", speaker, monologue);
    }

    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s talks to %s", actor, speaker);
    }
}
