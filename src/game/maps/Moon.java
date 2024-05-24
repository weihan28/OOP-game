package game.maps;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import java.util.List;

public class Moon extends GameMap {
    int[] DEFAULT_PLAYER_SPAWN = {0, 0};

    public Moon(FancyGroundFactory groundFactory, List<String> mapString){
        super(groundFactory, mapString);
    }
    public Action getTravelAction(){
        return new TravelAction(this);
    }

    public Location getPlayerSpawn(){
        return this.at(DEFAULT_PLAYER_SPAWN[0], DEFAULT_PLAYER_SPAWN[1]);
    }
}
