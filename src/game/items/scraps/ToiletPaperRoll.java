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

    public int getCredits(){
        return credits;
    }

    @Override
    public String Purchase(Actor actor) {
        return null;
    }
}
