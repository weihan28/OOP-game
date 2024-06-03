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
     * Returns the sell logic for selling a PotOfGold
     * @param actor The actor that is selling the object.
     * @param map
     * @param buyer
     * @return
     */
    @Override
    public String sellFrom(Actor actor, GameMap map, Actor buyer) {
        String result;
        int moneyTakenChance = 25;
        int moneyRNG = new java.util.Random().nextInt(100);

        if (moneyRNG < moneyTakenChance) {
            result =  String.format("Failed to sell %s, Item taken but no money was given!", this);
        } else {
            int sellValue = getSellValue();
            actor.addBalance(sellValue);
            result =  String.format("Successfully sold %s for %d credits.", this, sellValue);
        }
        actor.removeItemFromInventory(this);
        return result;
    }

    @Override
    public int getSellValue() {
        return 500;
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
        if (otherActor.hasCapability(Status.SELLABLE_TOWARDS)) {
            actions.add(new SellAction(this, otherActor));
        }
        return actions;
    }
}
