package game;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;

import game.displays.FancyMessage;
import game.actors.*;
import game.factories.*;
import game.grounds.*;
import game.grounds.trees.SproutInheritree;
import game.maps.*;

import java.util.ArrayList;

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
        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        World world = initialiseWorld();
        world.run();
    }

    /**
     * Initialises the World with all entities and grounds within.
     * @return the World instance for the game.
     */
    private static World initialiseWorld() {
        World world = new World(new Display());
        Terminal terminal = CreateTerminal();
        Moon[] moons = {initialisePolymorphia(terminal), initialiseParkingLot(terminal), initialiseRefactorio(terminal)};
        for (Moon moon : moons){
            world.addGameMap(moon);
            terminal.addMoon(moon);
        }

        Player player = new Player("Intern", '@', 4);
        world.addPlayer(player, moons[0].getPlayerSpawn());
        player.addBalance(100);
        return world;
    }

    /**
     * Helper Function to Create a Terminal with items for sale.
     */
    private static Terminal CreateTerminal(){
        ArrayList<PurchasableFactory> purchasableFactories = new ArrayList<>();
        purchasableFactories.add(new EnergyDrinkFactory());
        purchasableFactories.add(new DragonSlayerSwordReplicaFactory());
        purchasableFactories.add(new ToiletPaperRollFactory());
        purchasableFactories.add(new AIDeviceFactory());
        return new Terminal(purchasableFactories);
    }

    /**
     * Creates and Initialises the Polymorphia Game Map.
     * @param terminal the terminal used in the moon.
     * @return A fully initialised Polymorphia Game Map.
     */
    private static Moon initialisePolymorphia(Terminal terminal){
        Moon gameMap = new Polymorphia();
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
        return gameMap;
    }

    /**
     * Creates and Initialises the FactoryParkingLot Game Map.
     * @param terminal the terminal used in the moon.
     * @return A fully initialised FactoryParkingLot Game Map.
     */
    private static Moon initialiseParkingLot(Terminal terminal){
        Moon gameMap = new FactoryParkingLot();
        gameMap.at(3,2).setGround(terminal);

        return gameMap;
    }

    /**
     * Creates and Initialises the Refactorio Game Map.
     * @param terminal the terminal used in the moon.
     * @return A fully initialised Refactorio Game Map.
     */
    private static Moon initialiseRefactorio(Terminal terminal){
        Moon gameMap = new Refactorio();
        gameMap.at(15,5).setGround(terminal);
        return gameMap;
    }
}
