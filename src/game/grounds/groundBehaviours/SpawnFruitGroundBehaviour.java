package game.grounds.groundBehaviours;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.items.fruitFactories.FruitFactory;

import java.util.List;
import java.util.Random;


public class SpawnFruitGroundBehaviour implements GroundBehaviour {
    private final Random random = new Random();
    private int spawnChance;
    private FruitFactory fruitFactory;

    public SpawnFruitGroundBehaviour(int spawnChance, FruitFactory fruitFactory) {
        this.spawnChance = spawnChance;
        this.fruitFactory = fruitFactory;
    }

    @Override
    public void doAction(Ground ground, Location location) {
        if(random.nextInt(100) <= spawnChance){
            spawnFruit(location);
        }
    }

    private void spawnFruit(Location location){
        List<Exit> exits = location.getExits();
        Exit exitToSpawn = exits.get(random.nextInt(exits.size()));
        exitToSpawn.getDestination().addItem(fruitFactory.createFruit());
    }
}
