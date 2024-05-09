package game;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.HuntsmanSpider;
import game.actors.Player;
import game.displays.FancyMessage;
import game.grounds.*;
import game.items.scraps.LargeBolt;
import game.items.scraps.MetalPipe;
import game.items.scraps.MetalSheet;
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
                new Wall(), new Floor(), new Puddle(), new ComputerSystem());

        List<String> map = Arrays.asList(
                        "...~~~~.........~~~...........",
                        "...~~~~.......................",
                        "...~~~........................",
                        "..............................",
                        ".............#####............",
                        ".............#=__#...........~",
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
        gameMap.at(1,1).addItem(new LargeBolt());
        gameMap.at(2,1).addItem(new MetalSheet());
        gameMap.at(15,8).addItem(new MetalPipe());

        gameMap.at(15, 10).addActor(new HuntsmanSpider());
        gameMap.at(7, 9).addActor(new HuntsmanSpider());

        gameMap.at(3, 1).setGround(new SaplingInheritree());

        gameMap.at(20, 1).setGround(new Crater());
        gameMap.at(20, 10).setGround(new Crater());
    }
}
