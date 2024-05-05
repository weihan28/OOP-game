package game.behaviours;

import edu.monash.fit2099.engine.actions.DoNothingAction;
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
 * @see edu.monash.fit2099.demo.mars.Application
 *
 * Created by: Riordan D. Alfredo
 * @author Riordan D. Alfredo
 * Modified by:
 * @author chinweihan
 */
public class FollowBehaviour implements Behaviour {
    private Status statusToFollow;
    private Actor target;

    public FollowBehaviour(Status statusToFollow) {
        this.statusToFollow = statusToFollow;
        this.target = null;
    }

    public void setTarget(Actor actor) {
        this.target = actor;
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {
        boolean newTargetInRange = updateNewTarget(actor, map);
        if (target==null || !map.contains(target) || !map.contains(actor))
            return null;

        if (!newTargetInRange){
            Action action = getFollowDirection(actor, target, map);
            return action;
        }
        return null;
    }

    /**
     * Gets the next MoveActorAction to follow the target.
     * Returns doNothingAction if there are no valid directions that move the actor closer to the target.
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
        return new DoNothingAction();
    }

    /**
     * Updates the target if another actor is within the range.
     * @param actor
     * @param map
     * @return Updates the target and returns true if another valid target is nearby.
     */
    private boolean updateNewTarget(Actor actor, GameMap map) {
        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()){
                Actor target = destination.getActor();
                if (target.hasCapability(statusToFollow)){
                    this.target = target;
                    return true;
                }
            }
        }
        return false;
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
