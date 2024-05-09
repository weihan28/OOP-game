package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.items.fruits.EnergyDrink;
import game.items.scraps.DragonSlayerSwordReplica;
import game.items.scraps.Purchasable;
import game.items.scraps.PurchaseAction;
import game.items.scraps.ToiletPaperRoll;

import java.util.ArrayList;

public class ComputerSystem extends Ground {
    private final ArrayList<Purchasable> VendingItems = new ArrayList<Purchasable>();
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public ComputerSystem() {
        super('=');
        this.VendingItems.add(new DragonSlayerSwordReplica());
        this.VendingItems.add(new ToiletPaperRoll());
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        for (Purchasable item : this.VendingItems) {
            actions.add(new PurchaseAction(item));
        }
        return actions;
    }
}
