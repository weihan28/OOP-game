package game.items.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * An interface for purchasable objects.
 */
public interface Sellable {
    /**
     * Called when an actor sells the object.
     *
     * @param actor The actor that is selling the object.
     * @param map
     * @param buyer
     * @return The description of the selling outcome.
     */
    public String sellFrom(Actor actor, GameMap map, Actor buyer);

    /**
     * Get the value that will be given to the user if they sell the item
     * @return
     */
    public int getSellValue();

}
