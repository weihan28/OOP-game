package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class representing the pickup behaviour of actors. Used by Alien Bug.
 *
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 * @author Anthony Lew
 *
 */
public class PickUpBehaviour implements Behaviour {
    private final Random random = new Random();

    /**
     * Returns a PickUpAction to pick up an item below, if possible.
     * If no item is found, returns null.
     *
     * @param actor the Actor enacting the behaviour
     * @param map the map that actor is currently on
     * @return an Action, or null if no PickUpAction is possible
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        ArrayList<Action> actions = new ArrayList<>();

        for (Item item : map.locationOf(actor).getItems()) {
            actions.add(item.getPickUpAction(actor));
        }
        if (!actions.isEmpty()) {
            return actions.get(random.nextInt(actions.size()));
        }
        else {
            return null;
        }

    }
}
