package game.items.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.items.fruits.Consumable;
import game.items.fruits.ConsumeAction;

import java.util.Random;

/**
 * A class that represents a Jar of Pickles in the game.
 **/
public class JarOfPickles extends Item implements Consumable {
    private final Random rand = new Random();
    private final int expireChance;
    private final int healAmount;
    private final int damageAmount;

    /**
     * Constructor method for JarOfPickles. It is a subclass of Item and implements Consumable.
     * It is a special item that has a 50% chance of expiring when consumed.
     * It heals the Actor by 1 health if it is not expired, otherwise it damages the Actor by 1 health.
     */
    public JarOfPickles() {
        super("Jar of Pickles", 'n', true);
        this.expireChance = 50;
        this.healAmount = 1;
        this.damageAmount = 1;
    }

    /**
     * Returns true if the JarOfPickles is expired, false otherwise.
     * @return
     */
    private boolean isExpired(){
        return rand.nextInt(100) <= expireChance;
    }

    /**
     * Consumes the Item and heals the Actor if it is not expired, otherwise it damages the Actor.
     * @param actor The actor that will consume the Item.
     * @return
     */
    @Override
    public String consumedBy(Actor actor) {
        actor.removeItemFromInventory(this);
        if(isExpired()){
            actor.heal(healAmount);
            return String.format("%s heals %s by %d", this, actor,healAmount);
        } else {
            actor.hurt(damageAmount);
            return String.format("%s feels sick",actor);
        }
    }

    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = super.allowableActions(owner);
        actions.add(new ConsumeAction(this));
        return actions;
    }
}
