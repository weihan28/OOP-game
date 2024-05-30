package game.maps;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import java.util.Random;

public class TeleportAction extends Action {

    @Override
    public String execute(Actor actor, GameMap map) {

        Random random = new Random();
        Location randomLocation;

        int xCoordinate = random.nextInt(map.getXRange().max() + 1);  // max() returns the upper limit (inclusive), need to add 1 for bound
        int yCoordinate = random.nextInt(map.getYRange().max() + 1);

        randomLocation = new Location(map, xCoordinate, yCoordinate);


    }

    @Override
    public String menuDescription(Actor actor) {
        return "Teleport with THESEUS";
    }
}





