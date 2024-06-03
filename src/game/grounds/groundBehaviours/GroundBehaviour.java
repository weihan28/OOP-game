package game.grounds.groundBehaviours;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

/**
 * Interface representing a GroundBehaviour
 */
public interface GroundBehaviour {
   void doAction(Ground ground, Location location);
}
