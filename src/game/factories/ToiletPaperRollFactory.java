package game.factories;

import game.items.actions.Purchasable;
import game.items.scraps.ToiletPaperRoll;

/**
 * A class that represents a Factory that creates ToiletPaperRoll.
 */
public class ToiletPaperRollFactory implements PurchasableFactory {
    public Purchasable createPurchasable() {
        return new ToiletPaperRoll();
    }
}
