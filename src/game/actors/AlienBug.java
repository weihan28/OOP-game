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
        this.behaviours.put(30, new WanderBehaviour());
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

    /**
     * Method that can be executed when the alien bug is unconscious due to the action of another actor. Also drops all items from inventory.
     * @param actor the perpetrator
     * @param map where the actor fell unconscious
     * @return a string describing what happened when the actor is unconscious
     */
    @Override
    public String unconscious(Actor actor, GameMap map) {
        // move this to monster class so that all monsters can drop items?
        List<Item> items = List.copyOf(getItemInventory());
        for (Item item : items) {
            item.getDropAction(this).execute(this, map);
        }

        map.removeActor(this);
        return this + " met their demise at the hand of " + actor + "dropped" + items;
    }
}