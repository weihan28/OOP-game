package game.items.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;
import game.items.actions.ConsumeAction;
import game.items.actions.Purchasable;
import game.items.actions.SellAction;
import game.items.actions.Sellable;

import java.util.Random;
/**
 * A class that represents a Toilet Paper Roll in the game.
 */
public class ToiletPaperRoll extends Item implements Purchasable, Sellable {
    private final Random random = new Random();
    private final int cost = 5;
    private final int discountCost = 1;
    private final int chanceDiscount = 75;

    public ToiletPaperRoll() {
        super("ToiletPaperRoll", 's', true);
        this.addCapability(Status.SELLABLE);
    }

    /**
     * Called when an actor is purchasing the item.
     * @param actor The actor that is purchasing the object.
     * @return the result string of the purchase.
     */
    @Override
    public String purchaseBy(Actor actor) {
        actor.addItemToInventory(this);
        return String.format("%s successfully purchased %s", actor, this);
    }

    @Override
    public int getCost() {
        return (random.nextInt(100)<=chanceDiscount) ? cost : discountCost;
    }

    @Override
    public String SellFrom(Actor actor) {
        int deathRNG = new java.util.Random().nextInt(100);
        if (deathRNG > 50) { // If you die
            actor.hurt(Integer.MAX_VALUE);
            return ("Failed to sell Toilet Paper Roll, and Killed in the process!");
        } else {
            actor.removeItemFromInventory(this);
            actor.addBalance(this.getSellValue());
            return "Successfully sold Toilet Paper Roll for " + this.getSellValue() + " credits.";
        }

    }

    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.VENDOR)) {
            actions.add(new SellAction(this));
        }
        return actions;
    }

    @Override
    public int getSellValue() {
        return 1;
    }
}
