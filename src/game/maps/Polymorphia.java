package game.maps;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.grounds.Dirt;
import game.grounds.Floor;
import game.grounds.Puddle;
import game.grounds.Wall;

import java.util.Arrays;
import java.util.List;

public class Polymorphia extends Moon {
    private static List<String> mapString = Arrays.asList(
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
    private static FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Puddle());
    private static final int PLAYER_SPAWN_X = 15;
    private static final int PLAYER_SPAWN_Y = 6;

    public Polymorphia(){
        super(groundFactory, mapString);
    }

    @Override
    public Location getPlayerSpawn(){
        return this.at(PLAYER_SPAWN_X,PLAYER_SPAWN_Y);
    }

    @Override
    public String toString() {
        return "Polymorphia";
    }
}
