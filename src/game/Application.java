package game;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;

import game.displays.FancyMessage;
import game.actors.*;
import game.factories.*;
import game.grounds.*;
import game.grounds.trees.SproutInheritree;
import game.maps.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @author chinweihan
 */
public class Application {
    /**
     * The main function containing the main game loop.
     *
     * @param args not used in this case
     */
    public static void main(String[] args) {

        World world = new World(new Display());

        Moon[] moons = {new Polymorphia(), new FactoryParkingLot(), new Refactorio()};

        for (GameMap moon : moons){
            world.addGameMap(moon);
        }

        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        Player player = new Player("Intern", '@', 4);
        world.addPlayer(player, moons[0].at(15, 6));
        player.addBalance(100);
        Terminal terminal = initaliseTerminal(moons);

        // separate initialisation of each moon's entities into functions for ease of comprehension
        /**
         * what happens if we accidentally put initialisePolymorphia(moon[1]),
         * is moon[1] really Polymorphia?
         * if someone deletes the moon in the middle, we would have to shift all indices backward.
         *
         * maybe encapsulate initilisation within creation of the moon Polymorphia.
         *
         * func createPolymorphia() returns Polymorphia Instance=> {
         *      polymorphia = new Polymorphia()
         *      initialisePolymorphia(polymorphia)
         *      return polymorphia
         * }
         */
        initialisePolymorphia(moons[0], terminal);
        initialiseParkingLot(moons[1], terminal);
        initialiseRefactorio(moons[2], terminal);
        world.run();
    }

    private static Terminal initaliseTerminal(Moon[] moons){
        ArrayList<PurchasableFactory> purchasableFactories = new ArrayList<>();
        purchasableFactories.add(new EnergyDrinkFactory());
        purchasableFactories.add(new DragonSlayerSwordReplicaFactory());
        purchasableFactories.add(new ToiletPaperRollFactory());
        purchasableFactories.add(new AIDeviceFactory());
        return new Terminal(purchasableFactories, moons);
    }

    /**
     * Initialises the entities such as items and actors (excluding Player) onto Polymorphia.
     *
     * @param gameMap the map of the game containing the player.
     * @param terminal the terminal to use in the map
     */
    private static void initialisePolymorphia(GameMap gameMap, Terminal terminal){
        gameMap.at(15,5).setGround(terminal);

        gameMap.at(3, 1).setGround(new SproutInheritree());
//        Spawner huntsmanSpiderSpawner = new ActorSpawner(new HuntsmanSpiderFactory(), 10);
//        Spawner susAstroSpawner = new ActorSpawner(new SuspiciousAstronautFactory(), 5);
//        gameMap.at(20, 10).setGround(new Crater(huntsmanSpiderSpawner));
//        gameMap.at(20, 5).setGround(new Crater(susAstroSpawner));
//
//        gameMap.at(1,1).addItem(new LargeBolt());
//        gameMap.at(2,1).addItem(new MetalSheet());
//        gameMap.at(15,8).addItem(new MetalPipe());
//        gameMap.at(16,8).addItem(new JarOfPickles());
//        gameMap.at(17,8).addItem(new PotOfGold());
//
//        gameMap.at(7, 9).addActor(new HuntsmanSpider());
//        gameMap.at(15,10).addActor(new AlienBug());
    }

    private static void initialiseParkingLot(GameMap gameMap, Terminal terminal){
        gameMap.at(3,2).setGround(terminal);
    }

    private static void initialiseRefactorio(GameMap gameMap, Terminal terminal){
        gameMap.at(15,5).setGround(terminal);

    }
}
