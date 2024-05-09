package game.items.scraps;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

import java.util.Random;

public class ToiletPaperRoll extends Item implements Purchasable{
    private final Random random = new Random();
    private final int cost = 5;
    private final int discountCost = 1;
    private final int chanceDiscount = 75;

    public ToiletPaperRoll() {
        super("ToiletPaperRoll", 's', true);
    }

    @Override
    public String purchaseBy(Actor actor) { // This should handle the computer systems purchase logic
        int purchaseCost = getCost();
        if (actor.getBalance()<cost) {
            return String.format("Insufficient credits to purchase ");
        }
        actor.deductBalance(cost);
        actor.addItemToInventory(this);
        return String.format("%s successfully purchased %s for %d credits", actor, this, purchaseCost);
    }

    @Override
    public int getCost() {
        return (random.nextInt(100)<=chanceDiscount) ? cost : discountCost;
    }
}
