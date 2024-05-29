package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.items.actions.Purchasable;

public class Theseus extends Item implements Purchasable {

    private final int cost = 100;

    public Theseus(){ super("Theseus", '^', true); }



    @Override
    public String purchaseBy(Actor actor) {
        actor.addItemToInventory(this);
        return String.format("%s successfully purchased %s", actor, this);
    }

    @Override
    public int getCost() { return cost; }
}
