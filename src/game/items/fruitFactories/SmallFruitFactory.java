package game.items.fruitFactories;

import game.items.fruits.Fruit;
import game.items.fruits.SmallFruit;

/**
 * A class that represents a Factory that creates a Small Fruit.
 */
public class SmallFruitFactory implements FruitFactory {
    @Override
    public Fruit createFruit() {
       return new SmallFruit();
    }
}
