package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;
import game.behaviours.WanderBehaviour;

import java.util.Map;
import java.util.TreeMap;

/**
 * A class representing the HuntsmanSpider monster.
 */
public class HuntsmanSpider extends Actor {
    private Map<Integer, Behaviour> behaviours = new TreeMap<>();

    public HuntsmanSpider() {
        super("Huntsman Spider", '8', 1);
        this.addCapability(Status.HOSTILE_TO_PLAYER);
        // lower number keyed behaviours are prioritised first
        this.behaviours.put(10, new AttackBehaviour());
        this.behaviours.put(20, new WanderBehaviour());
    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * The huntsman spider can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }

    /**
     * Creates and returns an intrinsic weapon.
     * Override this method to create an intrinsic weapon for
     * the current Actor with more interesting descriptions and/or different damage.
     *
     * @see Actor#getIntrinsicWeapon()
     * @return a freshly-instantiated IntrinsicWeapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(1, "bites", 25);
    }

}
