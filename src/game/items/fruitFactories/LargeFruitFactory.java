package game.items.fruitFactories;

import game.items.fruits.Fruit;
import game.items.fruits.LargeFruit;

public class LargeFruitFactory implements FruitFactory {
    @Override
    public Fruit createFruit() {
       return new LargeFruit();
    }
}
