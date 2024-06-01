package game.items.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;
import game.items.actions.Consumable;
import game.items.actions.ConsumeAction;
import game.items.actions.SellAction;
import game.items.actions.Sellable;

/**
 * A class that represents a Pot of Gold in the game.
 */
public class PotOfGold extends Item implements Consumable, Sellable {
    private final int addBalanceAmount;

    /**
     * Constructor method for pot of gold. It is a subclass of Item and implements Consumable.
     * It is a special item that adds 10 credits to the Actor's balance when consumed.
     */
    public PotOfGold() {
        super("Pot of Gold", '$', true);
        this.addBalanceAmount = 10;
        this.addCapability(Status.SELLABLE);
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
     * List of allowable actions that the item allows its owner do to other actor.
     *
     * @see Item#allowableActions(Actor, Location)
     * @param otherActor the other actor
     * @param location the location of the other actor
     * @return an unmodifiable list of Actions
     */

    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        if (otherActor.hasCapability(Status.VENDOR)) {
            actions.add(new SellAction(this));
        }
        return actions;
    }



    @Override
    public String SellFrom(Actor actor, GameMap map) {
        actor.removeItemFromInventory(this);
        int rand_change = new java.util.Random().nextInt(100);
        if (rand_change < 25) {
            return "Failed to sell Pot of Gold, Item taken but no money was given!";
        } else {
            actor.addBalance(this.getSellValue());
            return "Successfully sold Pot of Gold for " + this.getSellValue() + " credits.";
        }
    }

    @Override
    public int getSellValue() {
        return 500;
    }
}
