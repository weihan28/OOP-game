package game.items.scraps;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;
import game.items.actions.SellAction;
import game.items.actions.Sellable;
import java.util.Random;

/**
 * Class representing a Metal Sheet scrap.
 */
public class MetalSheet extends Item implements Sellable {
    public MetalSheet() {
        super("Metal sheet", '%', true);
    }

    /**
     * Returns the sell logic for selling a MetalSheet
     * In the instance it hits rng, the buyer will ask for a discount
     * @param actor The actor that is selling the object.
     * @param map
     * @param buyer
     * @return
     */
    @Override
    public String sellFrom(Actor actor, GameMap map, Actor buyer) {
        int discountChance = 50;
        int discountRNG = new Random().nextInt(100);
        int sellValue = getSellValue();

        if (discountRNG < discountChance) {
            if (getDecisionForDiscount(discountChance) == 'y') {
                sellValue = (int) (sellValue * discountChance / 100);
            } else {
                return String.format("The vendor did not buy the %s.", this);
            }
        }
        actor.removeItemFromInventory(this);
        actor.addBalance(sellValue);
        return String.format("Successfully sold %s for %d credits", this, sellValue);
    }

    /**
     * Helper getter method defined by interface to get sellvalue of bolt;
     * dependent on the discount chance (thanks wei for cleaning this up)
     * @param discountChance
     * @return
     */
    private char getDecisionForDiscount(int discountChance) {
        Display display = new Display();
        String askForDiscount =
                String.format("The vendor is asking for a %d%% discount. \n", discountChance) +
                String.format("He will buy %s if you agree, type 'y', type anything else to refuse", this);
        display.println(askForDiscount);
        return display.readChar();
    }

    /**
     * AllowableActions method must be overridden to allow the actor to sell the item.
     * @param otherActor the other actor
     * @param location the location of the other actor
     * @return
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.SELLABLE_TOWARDS)) {
            actions.add(new SellAction(this, otherActor));
        }
        return actions;
    }

    @Override
    public int getSellValue() {
        return 20;
    }
}