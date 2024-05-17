package game.items.scraps;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.items.actions.Purchasable;

import java.util.Random;
/**
 * A class that represents a Toilet Paper Roll in the game.
 */
public class ToiletPaperRoll extends Item implements Purchasable {
    private final Random random = new Random();
    private final int cost = 5;
    private final int discountCost = 1;
    private final int chanceDiscount = 75;

    public ToiletPaperRoll() {
        super("ToiletPaperRoll", 's', true);
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
}
