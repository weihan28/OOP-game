package game.items.scraps;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

public class ToiletPaperRoll extends Item implements Purchasable{

    protected final int credits = 5;
    /***
     * Constructor.
    */
    public ToiletPaperRoll() {
        super("ToiletPaperRoll", 's', true);
    }

    @Override
    public String Purchase(Actor actor) { // This should handle the computer systems purchase logic
        return null;
    }

    @Override
    public int getcredits() {
        return credits;
    }
}
