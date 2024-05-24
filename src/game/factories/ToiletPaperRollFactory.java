package game.factories;

import game.items.actions.Purchasable;
import game.items.scraps.ToiletPaperRoll;

public class ToiletPaperRollFactory implements PurchasableFactory {
    public Purchasable createPurchasable() {
        return new ToiletPaperRoll();
    }
}
