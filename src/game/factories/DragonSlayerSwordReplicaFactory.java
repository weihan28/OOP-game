package game.factories;

import game.items.scraps.DragonSlayerSwordReplica;
import game.items.actions.Purchasable;

/**
 * A class that represents a Factory that creates DragonSlayerSwordReplica.
 */
public class DragonSlayerSwordReplicaFactory implements PurchasableFactory {
    @Override
    public Purchasable createPurchasable() {
        return new DragonSlayerSwordReplica();
    }
}
