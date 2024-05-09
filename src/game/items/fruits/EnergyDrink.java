package game.items.fruits;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.items.scraps.Purchasable;

import java.util.Random;

/**
 * A class that represents a Energy Drink in the game.
 */
public class EnergyDrink extends Item implements Consumable, Purchasable {
    protected final int cost = 10;
    private final int healAmount = 1;
    private final Random random = new Random();

    public EnergyDrink() {
        super("Energy Drink", '*', true);
    }

    /**
     * Heals the actor and removes the item from their inventory.
     * @param actor The actor that will consume the Item.
     * @return
     */
    @Override
    public String consumedBy(Actor actor) {
        actor.heal(healAmount);
        actor.removeItemFromInventory(this);
        return String.format("%s heals %s by %d", this, actor,healAmount);
    }

    /**
     * Gets the allowable action for this item.
     * @param owner the actor that owns the item
     * @return
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = super.allowableActions(owner);
        actions.add(new ConsumeAction(this));
        return actions;
    }

    /**
     * Called when an actor purchases this item.
     * @param actor
     * @return
     */
    @Override
    public String purchaseBy(Actor actor) {
        actor.addItemToInventory(this);
        return String.format("%s successfully purchased %s", actor, this);
    }

    @Override
    public int getCost() {
        return (random.nextInt(100)<= 20) ? cost * 2 : cost;
    }
}
