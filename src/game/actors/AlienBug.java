package game.actors;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.behaviours.FollowBehaviour;
import game.behaviours.PickUpBehaviour;

import java.util.Random;

/**
 * A class representing the AlienBug monster.
 */
public class AlienBug extends Monster {
    private final static Random random = new Random();
    private final static String namePrefix = "Feature-";

    public AlienBug() {
        super(generateName(), 'a', 2);
        this.behaviours.put(10, new PickUpBehaviour());
        this.addCapability(Status.CAN_ENTER_FLOOR);
    }

    private static String generateName() {
        String digits = namePrefix;
        for (int i = 0; i < 3; i++) {
            digits += (String.valueOf(random.nextInt(10)));
        }
        return digits;
    }

    /**
     * Returns the actions that are to be performed by AlienBug to another actor.
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return list of actions to perform
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        if (otherActor.hasCapability(Status.FOLLOWABLE_BY_ALIEN)) {
            this.behaviours.put(20, new FollowBehaviour(otherActor));
        }
        return super.allowableActions(otherActor, direction, map);
    }
}