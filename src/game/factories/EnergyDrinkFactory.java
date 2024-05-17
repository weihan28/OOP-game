package game.factories;

import game.items.fruits.EnergyDrink;
import game.items.actions.Purchasable;

public class EnergyDrinkFactory implements PurchasableFactory {
    @Override
    public Purchasable createPurchasable() {
        return new EnergyDrink();
    }
}
