package game.factories;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.SuspiciousAstronaut;

/**
 * A class that represents a Factory that creates SuspiciousAstronaut.
 */
public class SuspiciousAstronautFactory implements ActorFactory {
    @Override
    public Actor createActor() {
        return new SuspiciousAstronaut();
    }
}
