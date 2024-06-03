package game.items.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;
import game.items.actions.Consumable;
import game.items.actions.ConsumeAction;
import game.items.actions.SellAction;
import game.items.actions.Sellable;

import java.util.Random;

/**
 * A class that represents a Jar of Pickles in the game.
 **/
public class JarOfPickles extends Item implements Consumable, Sellable {
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
        if(!isExpired()){
            actor.heal(healAmount);
            return String.format("%s heals %s by %d", this, actor,healAmount);
        } else {
            actor.hurt(damageAmount);
            return String.format("%s feels sick",actor);
        }
    }

    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        if (otherActor.hasCapability(Status.SELLABLE_TOWARDS)) {
            actions.add(new SellAction(this, otherActor));
        }
        return actions;
    }

    /**
     * Returns the sell logic for selling a JarOfPickles
     * @param actor The actor that is selling the object.
     * @param map
     * @param buyer
     * @return
     */
    @Override
    public String sellFrom(Actor actor, GameMap map, Actor buyer) {
        actor.removeItemFromInventory(this);
        int luckySellChance = 50;
        int luckySellRNG = rand.nextInt(100);
        if (luckySellRNG > luckySellChance) {
            actor.addBalance(2 * this.getSellValue());
            return "Successfully sold Jar of Pickles for " + 2  * this.getSellValue() + " credits instead of " + this.getSellValue() + " credits.";
        } else {
            actor.addBalance(this.getSellValue());
            return "Jar of Pickles Sold for " + this.getSellValue() + " credits.";
        }
    }

    /**
     * Helper getter method defined by interface to get sellvalue of JarOfPickles
     * @return
     */
    @Override
    public int getSellValue() {
        return 25;
    }
}
