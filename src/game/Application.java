package game;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.World;

import game.displays.FancyMessage;
import game.actors.*;
import game.factories.*;
import game.grounds.*;
import game.grounds.trees.SaplingInheritree;
import game.grounds.trees.SproutInheritree;
import game.items.scraps.*;
import game.spawners.ActorSpawner;
import game.spawners.Spawner;

import java.util.ArrayList;
import java.util.Arrays;
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

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(),
                new Wall(), new Floor(), new Puddle());

        List<String> map = Arrays.asList(
                        "...~~~~.........~~~...........",
                        "...~~~~.......................",
                        "...~~~........................",
                        "..............................",
                        ".............#####............",
                        ".............#___#...........~",
                        ".............#___#..........~~",
                        ".............##_##.........~~~",
                        ".................~~........~~~",
                        "................~~~~.......~~~",
                        ".............~~~~~~~........~~",
                        "......~.....~~~~~~~~.........~",
                        ".....~~~...~~~~~~~~~..........",
                        ".....~~~~~~~~~~~~~~~~........~",
                        ".....~~~~~~~~~~~~~~~~~~~....~~");

        GameMap gameMap = new GameMap(groundFactory, map);
        world.addGameMap(gameMap);

        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        Player player = new Player("Intern", '@', 4);
        world.addPlayer(player, gameMap.at(15, 6));
        player.addBalance(100);

        initialiseOtherEntities(gameMap);
        world.run();
    }

    /**
     * Initialises the entities such as items and actors (excluding Player) onto the game map.
     *
     * @param gameMap the map of the game containing the player.
     */
    private static void initialiseOtherEntities(GameMap gameMap){
        ArrayList<PurchasableFactory> purchasableFactories = new ArrayList<>();
        purchasableFactories.add(new EnergyDrinkFactory());
        purchasableFactories.add(new DragonSlayerSwordReplicaFactory());
        purchasableFactories.add(new ToiletPaperRollFactory());
        purchasableFactories.add(new AIDeviceFactory());
        gameMap.at(15,5).setGround(new Terminal(purchasableFactories));

        gameMap.at(3, 1).setGround(new SproutInheritree());

        gameMap.at(7,9).addActor(new HumanoidFigure());
        gameMap.at(7,7).addItem(new LargeBolt());
        gameMap.at(7,7).addItem(new MetalSheet());
        gameMap.at(7,7).addItem(new MetalPipe());

        gameMap.at(16,8).addItem(new JarOfPickles());
        gameMap.at(17,8).addItem(new PotOfGold());

//        Spawner huntsmanSpiderSpawner = new ActorSpawner(new HuntsmanSpiderFactory(), 10);

//        Spawner susAstroSpawner = new ActorSpawner(new SuspiciousAstronautFactory(), 5);
//        gameMap.at(20, 10).setGround(new Crater(huntsmanSpiderSpawner));
//        gameMap.at(20, 5).setGround(new Crater(susAstroSpawner));
//

//        gameMap.at(16,8).addItem(new JarOfPickles());
//        gameMap.at(17,8).addItem(new PotOfGold());
//
//        gameMap.at(7, 9).addActor(new HuntsmanSpider());
//        gameMap.at(15,10).addActor(new AlienBug());
    }
}
