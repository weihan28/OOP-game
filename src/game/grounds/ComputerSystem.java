package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import game.items.fruits.EnergyDrink;
import game.items.scraps.DragonSlayerSwordReplica;
import game.items.scraps.Purchasable;
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
}
