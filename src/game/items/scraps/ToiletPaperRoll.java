package game.items.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.grounds.ComputerSystem;
import game.actors.AttackAction;

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
        actor.addItemToInventory(this);
        return "You have successfully purchased " + this;
    }

    @Override
    public int getCost() {
        return credits;
    }

    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = new ActionList();
        actions.add(new PurchaseAction(this));
        return actions;
    }
}
