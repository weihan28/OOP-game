package game.grounds.trees;

import game.grounds.groundBehaviours.GrowGroundBehaviour;

public class YoungInheritree extends Inheritree {
    private int tickToGrow = 5;

    public YoungInheritree() {
        super('y');
        this.behaviours.put(1, new GrowGroundBehaviour(tickToGrow, new MatureInheritree()));
    }
}
