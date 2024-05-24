package game.items.scraps;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.items.actions.Sellable;

/**
 * Class representing a LargeBolt scrap.
 */
public class LargeBolt extends Item implements Sellable {
    public LargeBolt() {
        super("Large bolt", '+', true);
    }


    @Override
    public String SellFrom(Actor actor) {
        actor.removeItemFromInventory(this);
        actor.addBalance(this.getSellValue());
        return "Successfully sold Large Bolt for " + this.getSellValue() + " credits.";
    }

    @Override
    public int getSellValue() {
        return 25; // 25 credits for a Largebolt
    }
}
