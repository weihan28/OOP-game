package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.actions.AttackAction;
import game.actors.Status;

/**
 * Class representing the attack behaviour of actors.
 */
public class AttackBehaviour implements Behaviour {

    /**
     * Gets the Attack Action when the target is hostile.
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return AttackAction to attack the target.
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()){
                Actor target = destination.getActor();
                if (target.hasCapability(Status.HOSTILE_TO_ENEMY)){
                    return new AttackAction(target, "");
                }
            }
        }
        return null;
    }
}

