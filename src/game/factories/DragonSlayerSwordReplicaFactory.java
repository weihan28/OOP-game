package game.factories;

import game.items.scraps.DragonSlayerSwordReplica;
import game.items.scraps.Purchasable;

public class DragonSlayerSwordReplicaFactory implements PurchasableFactory {
    @Override
    public Purchasable createPurchasable() {
        return new DragonSlayerSwordReplica();
    }
}
