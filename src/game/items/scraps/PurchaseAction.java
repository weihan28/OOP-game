package game.items.scraps;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class PurchaseAction extends Action {

    private final Purchasable PurchasableItem;

    public PurchaseAction(Purchasable purchasableItem) {
        this.PurchasableItem = purchasableItem;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String description = this.PurchasableItem.Purchase(actor);
        return String.format("%s purchased %s", actor, this.PurchasableItem, description);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " Can Purchase:  " + this.PurchasableItem;
    }
}
