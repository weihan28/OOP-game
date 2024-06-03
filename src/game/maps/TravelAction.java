package game.maps;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * An action class that allows the actor to travel between moons.
 */
public class TravelAction extends Action {
    private Moon moon;
    public TravelAction(Moon map){
        this.moon = map;
    }

    /**
     * Allows the actor to travel to another moon.
     *
     * @param actor The actor performing the action.
     * @param currentMap   The map the actor is on.
     * @return "Travelling to Polymorphia" if there is no other actor at the spawning location, "Travel failed" if there is.
     */
    @Override
    public String execute(Actor actor, GameMap currentMap) {
        if (!moon.isAnActorAt(moon.getPlayerSpawn())){
            currentMap.removeActor(actor);
            moon.addActor(actor, moon.getPlayerSpawn());
            return "Travelling to " + moon;
        }
        return "Travel Failed";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Travel to " + moon;
    }
}
