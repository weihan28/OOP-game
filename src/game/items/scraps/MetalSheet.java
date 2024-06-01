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
import java.util.Scanner;

/**
 * Class representing a Metal Sheet scrap.
 */
public class MetalSheet extends Item implements Sellable {
    public MetalSheet() {
        super("Metal sheet", '%', true);
    }

    @Override
    public String SellFrom(Actor actor, GameMap map) {
        int discountChance = 50;
        int discountRNG = new Random().nextInt(100);
        int sellValue = getSellValue();

        if (discountRNG < discountChance) {
            final char decision = getDecisionForDiscount(discountChance);
            if (decision == 'y') {
                sellValue = (int) (sellValue * discountChance / 100);
            } else {
                return String.format("The vendor did not buy the %s.", this);
            }
        }
        actor.removeItemFromInventory(this);
        actor.addBalance(sellValue);
        return String.format("Successfully sold %s for %d credits", this, sellValue);
    }

    private char getDecisionForDiscount(int discountChance) {
        Display display = new Display();
        String askForDiscount =
                String.format("The vendor is asking for a %d%% discount. \n", discountChance) +
                String.format("He will buy %s if you agree, type 'y', type anything else to refuse", this);
        display.println(askForDiscount);
        return display.readChar();
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
        return 20;
    }

}