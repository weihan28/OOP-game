package game.items.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.AttackAction;
import game.grounds.ComputerSystem;

public class DragonSlayerSwordReplica extends WeaponItem implements Purchasable {
    protected final int credits = 100;
    /**
     * Constructor.
     *
     */
    public DragonSlayerSwordReplica() {
        super("DragonSlayerSwordReplica", 'x', 50, "slashes", 75);
    }
    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = new ActionList();
        actions.add(new AttackAction(otherActor, location.toString(), this));
        if (location.getGround() instanceof ComputerSystem) {
            actions.add(new PurchaseAction(this));
        }
        return actions;
    }

    @Override
    public String Purchase(Actor actor) { // handle the computer systems purchase logic for this item
        // error if credits < 100
        // if has 100 credits, take and 50% chance of giving item, 50% chance throwing error
        if (actor.getBalance() < this.getcredits()) {
            return "Insufficient credits to purchase " + this;
        } else {
            actor.deductBalance(actor.getBalance() - this.getcredits());
            if (Math.random() < 0.5) {
                actor.addItemToInventory(this);
                return "You have successfully purchased " + this;
            } else {
                return "An error occurred while purchasing " + this;
            }
        }
    }

    @Override
    public int getcredits() {
        return credits;
    }
}
