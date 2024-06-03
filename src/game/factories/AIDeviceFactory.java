package game.factories;

import game.items.actions.Purchasable;
import game.items.scraps.AIDevice;

/**
 * A class that represents a Factory that creates AIDevice.
 */
public class AIDeviceFactory implements PurchasableFactory {
    public Purchasable createPurchasable() {
        return new AIDevice();
    }
}
