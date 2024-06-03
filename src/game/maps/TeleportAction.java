package game.maps;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import java.util.Random;

/**
 * An action class that allows the actor to teleport to a random location within the current map.
 */
public class TeleportAction extends Action {

    /**
     * Constructor of a teleport action.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     *
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        Random random = new Random();
        int xCoordinate = random.nextInt(map.getXRange().max() + 1);  // max() returns the upper limit (inclusive), add 1 for bound
        int yCoordinate = random.nextInt(map.getYRange().max() + 1);

        Location randomLocation = map.at(xCoordinate, yCoordinate);

        if(!randomLocation.containsAnActor()){
            map.moveActor(actor, randomLocation);
            return String.format("%s has been teleported to coordinate %s", actor, randomLocation);
        }
        return "Teleport fails";
    }

    @Override
    public String menuDescription(Actor actor) { return String.format("%s teleport with Theseus", actor); }
}





