package game.items.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.AttackAction;

import java.util.Random;

public class DragonSlayerSwordReplica extends WeaponItem implements Purchasable {
    private final Random random = new Random();
    private final int cost = 100;
    private final int purchaseChance = 50;
    /**
     * Constructor.
     *
     */
    public DragonSlayerSwordReplica() {
        super("DragonSlayerSwordReplica", 'x', 50, "slashes", 75);
    }

    @Override
    public String purchaseBy(Actor actor) {
        if (random.nextInt(100) <= purchaseChance) {
            actor.addItemToInventory(this);
            return "You have successfully purchased " + this;
        } else {
            return String.format("An error occurred while purchasing %s", this);
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
