package game.actors;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;

/**
 * A class representing the HuntsmanSpider monster.
 */
public class AlienBug extends Monster {

    public AlienBug() {
        super("Alien Bug", 'a', 2);
        // lower number keyed behaviours are prioritised first
        this.behaviours.put(30, new WanderBehaviour());
    }


}
