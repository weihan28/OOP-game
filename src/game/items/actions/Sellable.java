package game.items.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * An interface for sellable objects.
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
     * get the sell value of the purchasable
     * @return
     */
    public int getSellValue();

}
