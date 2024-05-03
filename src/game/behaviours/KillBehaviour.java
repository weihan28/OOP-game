package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.KillAction;
import game.actors.Status;

/**
 * An Action that enables an Actor attacks another Actor.
 */
public class KillBehaviour implements Behaviour {
    @Override
    public Action getAction(Actor actor, GameMap map) {
        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()){
                Actor target = destination.getActor();
                if (target.hasCapability(Status.HOSTILE_TO_ENEMY)){
                    return new KillAction(target, "");
                }
            }
        }
        return null;
    }
}

