package game.actors;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.behaviours.PickUpBehaviour;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * A class representing the HuntsmanSpider monster.
 */
public class AlienBug extends Monster {
    private final static Random random = new Random();
    private final static String namePrefix = "Feature-";

    public AlienBug() {
        super(generateName(), 'a', 2);
        this.behaviours.put(10, new PickUpBehaviour());
        this.behaviours.put(20, new FollowBehaviour(Status.FOLLOWABLE_BY_ALIEN));
        // assumption: alien bug can enter spaceship, should capability be added specifically for alien bug?
        this.addCapability(Status.CAN_ACTOR_ENTER);
    }

    private static String generateName() {
        String digits = namePrefix;
        for (int i = 0; i < 3; i++) {
            digits += (String.valueOf(random.nextInt(10)));
        }
        return digits;
    }
}