package game.grounds.trees;

import edu.monash.fit2099.engine.positions.Location;
import game.grounds.groundBehaviours.GrowGroundBehaviour;

public class YoungInheritree extends Inheritree {
    private int tickToGrow = 5;

    public YoungInheritree() {
        super('y');
        this.behaviours.put(10, new GrowGroundBehaviour(tickToGrow, new MatureInheritree()));

    }
}
