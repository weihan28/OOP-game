package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;

import java.util.Random;

/**
 * An action class for an actor to kill another actor
 */
public class KillAction extends Action {

    /**
     * The Actor that is to be killed
     */
    private Actor target;

    /**
     * The direction of incoming attack.
     */
    private String direction;

    /**
     * Constructor.
     *
     * @param target the Actor to kill
     * @param direction the direction where the attack should be performed (only used for display purposes)
     */
    public KillAction(Actor target, String direction, Weapon weapon) {
        this.target = target;
        this.direction = direction;
    }

    /**
     * Constructor with intrinsic weapon as default
     *
     * @param target the actor to attack
     * @param direction the direction where the attack should be performed (only used for display purposes)
     */
    public KillAction(Actor target, String direction) {
        this.target = target;
        this.direction = direction;
    }

    /**
     * Allow the Actor to attack.
     *
     * Overrides Action.execute()
     *
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of the Action suitable for the menu
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        int damage = target.getAttributeMaximum(BaseActorAttributes.HEALTH);
        String result = actor + " kills " + target;
        target.hurt(damage);
        if (!target.isConscious()) {
            result += "\n" + target.unconscious(actor, map);
        }

        return result;
    }

    /**
     * Returns a description of this attack suitable to display in the menu.
     *
     * @param actor The actor performing the action.
     * @return a String, e.g. "Intern (4/4) punches Huntsman Spider (1/1) for 5 damage."
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " kills " + target + " at " + direction;
    }
}
