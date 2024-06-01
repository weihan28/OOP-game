package game.items.scraps;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;
import game.items.actions.SellAction;
import game.items.actions.Sellable;

/**
 * Class representing a LargeBolt scrap.
 */
public class LargeBolt extends Item implements Sellable {
    public LargeBolt() {
        super("Large bolt", '+', true);
    }


    @Override
    public String sellFrom(Actor actor, GameMap map) {
        actor.removeItemFromInventory(this);
        actor.addBalance(this.getSellValue());
        return String.format("Successfully sold %s for %d credits.", this, getSellValue());
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
        return 25;
    }
}
