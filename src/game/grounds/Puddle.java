package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.items.fruits.Consumable;
import game.items.fruits.ConsumeAction;

/**
 * A class that represents a puddle in the game.
 */
public class Puddle extends Ground implements Consumable {
    private final int addMaxHealthAmount;

    public Puddle() {
        super('~');
        this.addMaxHealthAmount = 1;
    }

    @Override
    public String consumedBy(Actor actor) {
        actor.modifyAttributeMaximum(BaseActorAttributes.HEALTH, ActorAttributeOperations.INCREASE, addMaxHealthAmount);
        return String.format("%s feels invigorated", actor);
    }

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
