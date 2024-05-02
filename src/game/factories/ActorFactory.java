package game.factories;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * Interface for Factories that creates Actors.
 */
public interface ActorFactory {
    /**
     * A method that simply creates and returns a certain Actor object.
     * @return Actor that is created.
     */
    public Actor createActor();
}
