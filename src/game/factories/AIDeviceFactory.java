package game.factories;

import game.items.actions.Purchasable;
import game.items.scraps.AIDevice;

public class AIDeviceFactory implements PurchasableFactory {
    public Purchasable createPurchasable() {
        return new AIDevice();
    }
}
