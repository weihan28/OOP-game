package game.grounds.groundBehaviours;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

/**
 * Class representing the grow behaviour of grounds.
 */
public class GrowGroundBehaviour implements GroundBehaviour {
    private int counter;
    private int tickToGrow;
    private Ground nextGround;
    public GrowGroundBehaviour(int tickToGrow, Ground nextGround) {
        this.counter = 0;
        this.nextGround = nextGround;
        this.tickToGrow = tickToGrow;
    }

    /**
     * Grows into the next ground after a certain amount of ticks
     * @param ground
     * @param location
     */
    @Override
    public void doAction(Ground ground, Location location) {
        counter++;
        if(counter % tickToGrow == 0){
            location.setGround(nextGround);
        }
    }
}
