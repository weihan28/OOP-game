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
        /**
         * The teleport will fail if the spot has another actor there.
         * should add a actor check using
         * moon.isAnActorAt(location)
         *
         */
        currentMap.removeActor(actor);
        moon.addActor(actor, moon.getPlayerSpawn());
        return "Travelling to " + moon;
        // how will travel of multiple players work?
        /**
         * multiple players is not currently supported with the current engine,
         * It still works if another player is to be added as an Actor,
         * but they wont be able to see their map display.
         * https://imgur.com/a/gvD1Ko2
         * https://imgur.com/lXS1kmX
         *
         * However, a multiple players will teleport seperately if it is possible,
         * they would teleport one by one. So this implementation is fine.
         * https://imgur.com/lXS1kmX
         *
         */
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Travel to " + moon;
    }
}
