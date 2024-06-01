package game.items.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * A class that represents a Sell Action in the game.
 */
public class SellAction extends Action {
    private final Sellable sellable;

    /**
     * Constructor of a sell action.
     * @param sellable
     */
    public SellAction(Sellable sellable) {
        this.sellable = sellable;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        // check sellable.hasenum isdefaultsold, if its true
        // then return just remove item, add balance and return string
        // if not, call the sellfrom method of the sellable item itself.
        return String.format(sellable.SellFrom(actor, map));
    }

    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s Sells: %s", actor, sellable);
    }
}
