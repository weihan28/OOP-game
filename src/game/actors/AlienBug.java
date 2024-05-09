package game.actors;

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
        this.behaviours.put(20, new FollowBehaviour(Status.FOLLOWABLE_BY_ALIEN));
        this.addCapability(Status.CAN_ENTER_FLOOR);
    }

    private static String generateName() {
        String digits = namePrefix;
        for (int i = 0; i < 3; i++) {
            digits += (String.valueOf(random.nextInt(10)));
        }
        return digits;
    }
}