package game.items.fruitFactories;

import game.items.fruits.Fruit;
import game.items.fruits.SmallFruit;

public class SmallFruitFactory implements FruitFactory {
    @Override
    public Fruit createFruit() {
       return new SmallFruit();
    }
}
