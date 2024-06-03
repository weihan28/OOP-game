package game.items.fruitFactories;

import game.items.fruits.Fruit;
import game.items.fruits.LargeFruit;

/**
 * A class that represents a Factory that creates a Large Fruit.
 */
public class LargeFruitFactory implements FruitFactory {
    @Override
    public Fruit createFruit() {
       return new LargeFruit();
    }
}
