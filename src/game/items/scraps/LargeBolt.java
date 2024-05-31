package game.items.scraps;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;
import game.actors.actions.AttackAction;
import game.items.actions.ConsumeAction;
import game.items.actions.SellAction;
import game.items.actions.Sellable;

/**
 * Class representing a LargeBolt scrap.
 */
public class LargeBolt extends Item implements Sellable {
    public LargeBolt() {
        super("Large bolt", '+', true);
        this.addCapability(Status.SELLABLE);
    }


    @Override
    public String SellFrom(Actor actor) {
        actor.removeItemFromInventory(this);
        actor.addBalance(this.getSellValue());
        return "Successfully sold Large Bolt for " + this.getSellValue() + " credits.";
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
        return 25; // 25 credits for a Large bolt
    }
}
