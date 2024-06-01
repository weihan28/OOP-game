package game.items.scraps;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
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
        this.addCapability(Status.SELLABLE);
    }

    @Override
    public String SellFrom(Actor actor, GameMap map) {
        int discountRNG = new Random().nextInt(100);
        if (discountRNG < 60) {
            System.out.println("The vendor is asking for a 50% discount. He will buy" + this.toString() + "If you agree, type 'y'.");
            Scanner discount = new Scanner(System.in);
            String input = discount.nextLine();
            if (input.equals("y")) {
                actor.removeItemFromInventory(this);
                actor.addBalance(this.getSellValue() / 2);
                return "Successfully sold MetalSheet for " + this.getSellValue() / 2 + " credits.";
            } else {
                return "The vendor did not buy the MetalSheet.";
            }
        } else {
            actor.removeItemFromInventory(this);
            actor.addBalance(this.getSellValue());
            return "Successfully sold MetalSheet for " + this.getSellValue() + " credits.";
        }
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
        return 20;
    }

}