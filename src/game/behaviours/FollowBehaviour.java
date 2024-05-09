package game.behaviours;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Behaviour;
import game.actors.Status;

/**
 * A class that figures out a MoveAction that will move the actor one step
 * closer to a target Actor.
 * Taken from the mars module and slightly modified.
 * @see edu.monash.fit2099.demo.mars.behaviours.FollowBehaviour
 *
 * Created by: Riordan D. Alfredo
 * @author Riordan D. Alfredo
 * Modified by:
 * @author chinweihan
 */
public class FollowBehaviour implements Behaviour {
    private Actor target;

    /**
     * Constructor for creating a FollowBehaviour instance.
     * @param target actor to follow.
     */
    public FollowBehaviour(Actor target) {
        this.target = target;
    }

    /**
     * Get the action fot the given actor to do.
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return A direction to follow if there is a target to follow, else null.
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        return getFollowDirection(actor, target, map);
    }

    /**
     * Gets the next MoveActorAction to follow the target.
     * Returns null if there are no valid directions that move the actor closer to the target.
     * @param actor
     * @param target
     * @param map
     * @return MoveActorAction the action to follow the target.
     */
    private Action getFollowDirection(Actor actor, Actor target, GameMap map) {
        Location here = map.locationOf(actor);
        Location there = map.locationOf(target);

        int currentDistance = distance(here, there);
        for (Exit exit : here.getExits()) {
            Location destination = exit.getDestination();
            if (destination.canActorEnter(actor)) {
                int newDistance = distance(destination, there);
                if (newDistance < currentDistance) {
                    return new MoveActorAction(destination, exit.getName());
                }
            }
        }
        return null;
    }

    /**
     * Compute the Manhattan distance between two locations.
     *
     * @param a the first location
     * @param b the first location
     * @return the number of steps between a and b if you only move in the four cardinal directions.
     */
    private int distance(Location a, Location b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }
}
