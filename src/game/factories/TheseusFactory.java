package game.factories;

import game.items.actions.Purchasable;
import game.items.scraps.Theseus;

public class TheseusFactory implements PurchasableFactory {
    public Purchasable createPurchasable() { return new Theseus(); }
}
