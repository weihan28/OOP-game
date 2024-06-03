package game.factories;

import game.items.fruits.EnergyDrink;
import game.items.actions.Purchasable;

/**
 * A class that represents a Factory that creates EnergyDrink.
 */
public class EnergyDrinkFactory implements PurchasableFactory {
    @Override
    public Purchasable createPurchasable() {
        return new EnergyDrink();
    }
}
