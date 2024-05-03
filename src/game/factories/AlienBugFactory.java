package game.factories;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.AlienBug;

public class AlienBugFactory implements ActorFactory {
    @Override
    public Actor createActor() {
        return new AlienBug();
    }
}
