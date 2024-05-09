package game.factories;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.HuntsmanSpider;

/**
 * A class that represents a Factory that creates HuntsmanSpiders.
 */
public class HuntsmanSpiderFactory implements ActorFactory {
    @Override
    public Actor createActor() {
        return new HuntsmanSpider();
    }
}
