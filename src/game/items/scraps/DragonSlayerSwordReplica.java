package game.items.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.AttackAction;

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
        return actions;
    }
    public int getCredits(){
        return credits;
    }

    @Override
    public String Purchase(Actor actor) {
        return null;
    }
}
