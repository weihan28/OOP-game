package game.actors;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;

public class SuspiciousAstronaut extends Monster{
    private final int HIT_RATE = 100;
    /**
     * A class representing the Suspicious Astronaut monster.
     */
    public SuspiciousAstronaut() {
        super("Suspicious Astronaut", 'ඞ', 99);
        this.addCapability(Status.HOSTILE_TO_PLAYER);
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
        return new IntrinsicWeapon(Integer.MAX_VALUE, "bonks", HIT_RATE);
    }
}
