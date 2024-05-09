package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.factories.DragonSlayerSwordReplicaFactory;
import game.factories.EnergyDrinkFactory;
import game.factories.PurchasableFactory;
import game.factories.ToiletPaperRollFactory;
import game.items.scraps.PurchaseAction;

import java.util.ArrayList;

public class Terminal extends Ground {
    private ArrayList<PurchasableFactory> purchasableFactories = new ArrayList<>();

    public Terminal() {
        super('=');
        this.purchasableFactories.add(new EnergyDrinkFactory());
        this.purchasableFactories.add(new DragonSlayerSwordReplicaFactory());
        this.purchasableFactories.add(new ToiletPaperRollFactory());
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        for (PurchasableFactory purchasableFactory: purchasableFactories) {
            actions.add(new PurchaseAction(purchasableFactory.createPurchasable()));
        }
        return actions;
    }
}
