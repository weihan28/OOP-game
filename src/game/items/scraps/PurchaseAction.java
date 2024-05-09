package game.items.scraps;

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
        return purchasable.purchaseBy(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s purchases %s", actor, purchasable);
    }
}
