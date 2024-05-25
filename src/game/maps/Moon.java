package game.maps;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import java.util.List;

/**
 * maybe make abstract so ppl dont instantiate a moon.
 */
public abstract class Moon extends GameMap {
    /**
     * make seperate variables instead?
     * DEFAULT_PLAYER_SPAWN_X
     * DEFAULT_PLAYER_SPAWN_Y
     * calling DEFAULT_PLAYER_SPAWN[0] is a magic number(consonance of meaning);
     *
     * alternate approach is just make getPlayerSpawn a abstract method.
     */
    int[] DEFAULT_PLAYER_SPAWN = {0, 0};

    public Moon(FancyGroundFactory groundFactory, List<String> mapString){
        super(groundFactory, mapString);
    }

    /**
     * this is not really needed
     *
     * just instantiate a travel action in terminal instead
     *  actions.add(new TravelAction(targetMoon));
     */
    public Action getTravelAction(){
        return new TravelAction(this);
    }

    public Location getPlayerSpawn(){
        return this.at(DEFAULT_PLAYER_SPAWN[0], DEFAULT_PLAYER_SPAWN[1]);
    }
}
