package game.factories;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.HuntsmanSpider;
import game.actors.SuspiciousAstronaut;

public class SuspiciousAstronautFactory implements ActorFactory {
    @Override
    public Actor createActor() {
        return new SuspiciousAstronaut();
    }
}
