package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.items.actions.Consumable;
import game.items.actions.ConsumeAction;

/**
 * A class that represents a puddle in the game.
 */
public class Puddle extends Ground implements Consumable {
    private final int addMaxHealthAmount;

    /**
     * Constructor method for Puddle. It is a subclass of Ground and implements Consumable.
     */
    public Puddle() {
        super('~');
        this.addMaxHealthAmount = 1;
    }

    /**
     * Consumes the Item and adds the health to the Actor's health.
     * @param actor The actor that will consume the Item.
     * @return
     */
    @Override
    public String consumedBy(Actor actor) {
        actor.modifyAttributeMaximum(BaseActorAttributes.HEALTH, ActorAttributeOperations.INCREASE, addMaxHealthAmount);
        return String.format("%s feels invigorated", actor);
    }

    /**
     * Gets the allowed action for puddle. ie: the consume action for drinking a puddle.
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = super.allowableActions(actor, location, direction);
        if (direction.equals("")) {
            actions.add(new ConsumeAction(this));
        }
        return actions;
    }

    @Override
    public String toString() {
        return "Puddle of Water";
    }
}
