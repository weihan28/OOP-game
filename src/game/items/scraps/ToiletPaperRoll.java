package game.items.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;
import game.items.actions.Purchasable;
import game.items.actions.SellAction;
import game.items.actions.Sellable;

import java.util.Random;
/**
 * A class that represents a Toilet Paper Roll in the game.
 */
public class ToiletPaperRoll extends Item implements Purchasable, Sellable {
    private final Random random = new Random();
    private final int cost;
    private final int discountCost;
    private final int chanceDiscount;

    public ToiletPaperRoll() {
        super("ToiletPaperRoll", 's', true);
        cost = 5;
        discountCost = 1;
        chanceDiscount = 75;
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
    public String sellFrom(Actor actor, GameMap map) {
        String result;
        int deathChance = 50;
        int deathRNG = new Random().nextInt(100);

        if (deathRNG <= deathChance) {
            actor.hurt(Integer.MAX_VALUE);
            result =
                String.format("Failed to sell %s, %s was killed in the process!\n", this, actor) +
                actor.unconscious(map);
        } else {
            int soldValue = getSellValue();
            actor.removeItemFromInventory(this);
            actor.addBalance(soldValue);
            result = String.format("%s successfully sold %s for %d credits", actor, this, soldValue);
        }
        return result;
    }

    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.SELLABLE_TOWARDS)) {
            actions.add(new SellAction(this));
        }
        return actions;
    }

    @Override
    public int getSellValue() {
        return 1;
    }
}
