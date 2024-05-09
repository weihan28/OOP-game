package game.items.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.AttackAction;

import java.util.Random;

/**
 * A class that represents a Dragon Slayer Sword in the game.
 */
public class DragonSlayerSwordReplica extends WeaponItem implements Purchasable {
    private final Random random = new Random();
    private final int cost = 100;
    private final int purchaseChance = 50;

    public DragonSlayerSwordReplica() {
        super("DragonSlayerSwordReplica", 'x', 50, "slashes", 75);
    }

    @Override
    public String purchaseBy(Actor actor) {
        int purchaseCost = getCost();
        if (actor.getBalance()<cost) {
            return String.format("Insufficient credits to purchase ");
        }
        actor.deductBalance(purchaseCost);
        if (random.nextInt(100) <= purchaseChance) {
            actor.addItemToInventory(this);
            return String.format("%s successfully purchased %s for %d credits", actor, this, purchaseCost);
        } else {
            return String.format(
                    "%d credits are taken from %s, but %s doesn't receive anything in return!",
                    purchaseCost, actor, actor);
        }
    }

    @Override
    public int getCost() {
        return cost;
    }

    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = new ActionList();
        actions.add(new AttackAction(otherActor, location.toString(), this));
        return actions;
    }
}
