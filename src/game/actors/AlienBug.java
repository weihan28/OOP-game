package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * A class representing the HuntsmanSpider monster.
 */
public class AlienBug extends Monster {
    protected Map<Integer, Behaviour> behaviours = new TreeMap<>();
    private final static Random random = new Random();
    private final static String namePrefix = "Feature-";

    public AlienBug() {
        super(generateName(), 'a', 2);
        this.behaviours.put(20, new FollowBehaviour(Status.FOLLOWABLE_BY_ALIEN));
        this.behaviours.put(30, new WanderBehaviour());
    }

    private static String generateName() {
        String digits = namePrefix;
        for (int i = 0; i < 3; i++) {
            digits += (String.valueOf(random.nextInt(10)));
        }
        return digits;
    }
}