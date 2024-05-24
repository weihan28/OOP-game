package game.maps;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class TravelAction extends Action {
    private Moon moon;
    public TravelAction(Moon map){
        this.moon = map;
    }
    @Override
    public String execute(Actor actor, GameMap currentMap) {
        currentMap.removeActor(actor);
        moon.addActor(actor, moon.getPlayerSpawn());
        return "Travelling to " + moon;
        // how will travel of multiple players work?
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Travel to " + moon;
    }
}
