package game.actors;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;
import game.behaviours.WanderBehaviour;

public class SuspiciousAstronaut extends Monster{

    /**
     * A class representing the HuntsmanSpider monster.
     */
    public SuspiciousAstronaut() {
        super("Suspicious Astronaut", 'ඞ', 99);
        this.addCapability(Status.HOSTILE_TO_PLAYER);
        this.behaviours.put(20, new AttackBehaviour());
        this.behaviours.put(30, new WanderBehaviour());
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
        return new IntrinsicWeapon(2147483647, "bonks", 100);
    }
}
