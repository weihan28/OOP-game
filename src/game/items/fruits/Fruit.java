package game.items.fruits;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

/**
 * Class representing a Fruit from the Inheritree.
 */
public abstract class Fruit extends Item implements Consumable{
    private final int healAmount;

    public Fruit(String name,char displayChar, int healAmount){
        super(name, displayChar, true);
        this.healAmount = healAmount;
    }

    /**
     * Lets the fruit be consumed by a actor.
     *
     * @see Consumable#consumedBy(Actor)
     * @param actor The actor that will consume the fruit.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String consumedBy(Actor actor) {
        actor.heal(healAmount);
        actor.removeItemFromInventory(this);
        return String.format("%s heals %s by %d", this, actor,healAmount);
    }

    /**
     * List of allowable actions that the item can perform to the current actor
     * 
     * @see Item#allowableActions(Actor) 
     * @param owner the actor that owns the item
     * @return an unmodifiable list of Actions
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = super.allowableActions(owner);
        actions.add(new ConsumeAction(this));
        return actions;
    }
}
