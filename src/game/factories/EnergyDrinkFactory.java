package game.factories;

import edu.monash.fit2099.engine.items.Item;
import game.items.fruits.EnergyDrink;
import game.items.scraps.Purchasable;

public class EnergyDrinkFactory implements PurchasableFactory {
    @Override
    public Purchasable createPurchasable() {
        return new EnergyDrink();
    }
}
