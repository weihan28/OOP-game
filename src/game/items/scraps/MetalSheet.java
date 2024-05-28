package game.items.scraps;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.items.actions.Sellable;
import java.util.Random;

/**
 * Class representing a Metal Sheet scrap.
 */
public class MetalSheet extends Item implements Sellable {
    public MetalSheet() {
        super("Metal sheet", '%', true);
    }

    @Override
    public String SellFrom(Actor actor) {
        int discountRNG = new Random().nextInt(100);
        if (discountRNG < 60) {
            System.out.println("The vendor is asking for a 50% discount. He will buy" + this.toString() + "If you agree, type 'y'.");
            String input = System.console().readLine();
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
    public int getSellValue() {
        return 20;
    }
}
