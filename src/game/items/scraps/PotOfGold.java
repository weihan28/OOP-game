package game.items.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.items.fruits.Consumable;
import game.items.fruits.ConsumeAction;

public class PotOfGold extends Item implements Consumable {
    private final int addBalanceAmount;
    public PotOfGold() {
        super("Pot of Gold", '$', true);
        this.addBalanceAmount = 10;
    }

    @Override
    public String consumedBy(Actor actor) {
        actor.removeItemFromInventory(this);
        actor.addBalance(addBalanceAmount);
        return String.format("gains %d credits. The rest are held as tax by the factory", addBalanceAmount);
    }

    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = super.allowableActions(owner);
        actions.add(new ConsumeAction(this));
        return actions;
    }
}
