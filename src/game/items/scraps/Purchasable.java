package game.items.scraps;

import edu.monash.fit2099.engine.actors.Actor;

public interface Purchasable {
    public String purchaseBy(Actor actor);

    public int getCost();
}
