package game.items.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
/**
 * A class that represents a Purchase Action in the game.
 */
public class PurchaseAction extends Action {
    private final Purchasable purchasable;

    /**
     * Constructor of a purchase action.
     * @param purchasable the purchasable object that is being purchased.
     */
    public PurchaseAction(Purchasable purchasable) {
        this.purchasable = purchasable;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        int purchaseCost = purchasable.getCost();
        if (actor.getBalance() < purchaseCost){
            return  String.format("Actor has insufficient credits to purchase %s", purchasable);
        }
        actor.deductBalance(purchaseCost);
        return String.format("%s for %d credits", purchasable.purchaseBy(actor), purchaseCost);
    }

    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s purchases %s", actor, purchasable);
    }
}
