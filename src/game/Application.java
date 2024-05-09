package game;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;

import game.displays.FancyMessage;
import game.actors.*;
import game.factories.ActorFactory;
import game.factories.AlienBugFactory;
import game.factories.HuntsmanSpiderFactory;
import game.factories.SuspiciousAstronautFactory;
import game.grounds.*;
import game.items.scraps.*;
import game.spawners.ActorSpawner;
import game.spawners.Spawner;
import game.trees.SaplingInheritree;

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

        initialiseOtherEntities(gameMap);
        world.run();
    }

    /**
     * Initialises the entities such as items and actors (excluding Player) onto the game map.
     *
     * @param gameMap the map of the game containing the player.
     */
    private static void initialiseOtherEntities(GameMap gameMap){
        gameMap.at(15,5).setGround(new Terminal());
        gameMap.at(3, 1).setGround(new SaplingInheritree());
        Spawner huntsmanSpiderSpawner = new ActorSpawner(new HuntsmanSpiderFactory(), 10);
        Spawner susAstroSpawner = new ActorSpawner(new SuspiciousAstronautFactory(), 5);
        gameMap.at(20, 10).setGround(new Crater(huntsmanSpiderSpawner));
        gameMap.at(20, 5).setGround(new Crater(susAstroSpawner));

        gameMap.at(1,1).addItem(new LargeBolt());
        gameMap.at(2,1).addItem(new MetalSheet());
        gameMap.at(15,8).addItem(new MetalPipe());
        gameMap.at(16,8).addItem(new JarOfPickles());
        gameMap.at(17,8).addItem(new PotOfGold());

        gameMap.at(7, 9).addActor(new HuntsmanSpider());
        gameMap.at(15,10).addActor(new AlienBug());
    }
}
