package game.factories;

import game.items.actions.Purchasable;
import game.items.scraps.Theseus;

/**
 * A class that represents a Factory that creates Theseus.
 */
public class TheseusFactory implements PurchasableFactory {
    public Purchasable createPurchasable() { return new Theseus(); }
}
