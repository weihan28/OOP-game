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
public class HuntsmanSpider extends Monster {

    public HuntsmanSpider() {
        super("Huntsman Spider", '8', 1);
        this.addCapability(Status.HOSTILE_TO_PLAYER);
        // lower number keyed behaviours are prioritised first
        this.behaviours.put(10, new AttackBehaviour());
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
