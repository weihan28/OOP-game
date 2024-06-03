package game.factories;

import game.items.actions.Purchasable;

/**
 * A interface for factories that creates Purchasables.
 */
public interface PurchasableFactory {
    public Purchasable createPurchasable();
}
