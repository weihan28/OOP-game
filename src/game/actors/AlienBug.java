package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * A class representing the HuntsmanSpider monster.
 */
public class AlienBug extends Actor {
    protected Map<Integer, Behaviour> behaviours = new TreeMap<>();
    private final static Random random = new Random();
    private final static String name = "Feature-" + random.nextInt(1000);
    public AlienBug() {
        super(AlienBug.name , 'a', 2);
        // lower number keyed behaviours are prioritised first
        this.behaviours.put(30, new WanderBehaviour());
    }


    /**
     * Select and return an action to perform on the current turn.
     *
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the Action to be performed
     */
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (actions.size() > 0){
            return actions.get(0);
        }

        //detect adjacent player and start following
        for (Exit exit : map.locationOf(this).getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor()){
                Actor target = destination.getActor();
                if (target.hasCapability(Status.FOLLOWABLE_BY_ALIEN)){
                    this.behaviours.put(50, new FollowBehaviour(target));
                }
            }
        }

        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }
}
