package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * A class that represents a wall.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 * @author chinweihan
 */
public class Wall extends Ground {

    public Wall() {
        super('#');
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }
}
