package game.items.scraps;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class PurchaseAction extends Action {

    private final Purchasable purchasable;

    public PurchaseAction(Purchasable purchasable) {
        this.purchasable = purchasable;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String description = purchasable.Purchase(actor);
        return String.format("%s purchased %s", actor, purchasable, description);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " Can Purchase:  " + purchasable;
    }
}
