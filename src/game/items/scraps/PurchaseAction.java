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
        if (actor.getBalance() - this.PurchasableItem.getcredits() >= 0) {
            String description = this.PurchasableItem.Purchase(actor);
            return String.format("%s purchased %s", actor, this.PurchasableItem, description);
        } else {
            return String.format("%s does not have enough credits to purchase %s", actor, this.PurchasableItem);
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " purchased " + this.PurchasableItem;
    }
}
