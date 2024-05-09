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
        int cost = purchasable.getCost();
        if (actor.getBalance()<cost) {
           return String.format("Insufficient credits to purchase ");
        }
        actor.deductBalance(cost);
        String description = purchasable.purchaseBy(actor);
        return String.format("%s purchased %s.\n%s", actor, purchasable, description);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " can purchase:  " + purchasable;
    }
}
