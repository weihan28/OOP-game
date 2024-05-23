package game.grounds.groundBehaviours;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

public class GrowBehaviour implements GroundBehaviour {
    private int counter;
    private int tickToGrow;
    private Ground nextGround;
    public GrowBehaviour(int tickToGrow, Ground nextGround) {
        this.counter = 0;
        this.nextGround = nextGround;
        this.tickToGrow = tickToGrow;
    }

    @Override
    public void doAction(Ground ground, Location location) {
        counter++;
        if(counter % tickToGrow == 0){
            location.setGround(nextGround);
        }
    }
}
