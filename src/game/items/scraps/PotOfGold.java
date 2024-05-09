package game.items.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.items.fruits.Consumable;
import game.items.fruits.ConsumeAction;

/**
 * A class that represents a Pot of Gold in the game.
 */
public class PotOfGold extends Item implements Consumable {
    private final int addBalanceAmount;

    /**
     * Constructor method for pot of gold. It is a subclass of Item and implements Consumable.
     * It is a special item that adds 10 credits to the Actor's balance when consumed.
     */
    public PotOfGold() {
        super("Pot of Gold", '$', true);
        this.addBalanceAmount = 10;
    }

    /**
     * Consumes the Item and adds the balance to the Actor's balance.
     * @param actor The actor that will consume the Item.
     * @return
     */
    @Override
    public String consumedBy(Actor actor) {
        actor.removeItemFromInventory(this);
        actor.addBalance(addBalanceAmount);
        return String.format("gains %d credits. The rest are held as tax by the factory", addBalanceAmount);
    }

    /**
     * Returns the list of allowable actions for the Item.
     * @param owner the actor that owns the item
     * @return
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = super.allowableActions(owner);
        actions.add(new ConsumeAction(this));
        return actions;
    }
}
