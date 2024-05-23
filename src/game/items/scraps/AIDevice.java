package game.items.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.items.actions.Purchasable;
import game.items.actions.Monologuable;
import game.items.actions.MonologueAction;

import java.util.Random;
import java.util.ArrayList;

/**
 * A class that represents an AI Device in the game known as Astley.
 */
public class AIDevice extends Item implements Purchasable, Monologuable{
    private final int cost;
    private final int subscriptionFee;
    private int counter;
    private boolean isSubscribed;
    private final Random random = new Random();

    public AIDevice() {
        super("Astley", 'z', true);
        this.counter = 0;
        this.cost = 50;
        this.subscriptionFee = 1;
        this.isSubscribed = true;
    }

    /**
     * Called when an actor is purchasing the item.
     * @param actor The actor that is purchasing the object.
     * @return the result string of the purchase.
     */
    @Override
    public String purchaseBy(Actor actor) {
        actor.addItemToInventory(this);
        return String.format("%s successfully purchased %s", actor, this);
    }

     /**
     * Get the price of the object.
     * @return the price of the object.
     */
    @Override
    public int getCost() {
        return cost;
    }

    /**
     * Applies subscription fee to actor every 5 ticks.
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor           The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        counter++;
        if((counter % 5 == 0)){
            if (actor.getBalance() >= subscriptionFee){
                actor.deductBalance(subscriptionFee);
                isSubscribed = true;
            } else {
                isSubscribed = false;
            }
        }
        super.tick(currentLocation, actor);
    }

    /**
     * List of allowable actions that the item can perform to the current actor
     * 
     * @see Item#allowableActions(Actor) 
     * @param owner the actor that owns the item
     * @return an unmodifiable list of Actions
     */
     @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = super.allowableActions(owner);
        if (isSubscribed) {
            actions.add(getMonologueOptions(owner));
        }
        return actions;
    }

    /**
     * Called when an actor talks to the object.
     * @param owner The actor that is talking to the object.
     * @return An ActionList of possible MonologueActions
     */
    @Override
    public ActionList getMonologueOptions(Actor owner){
        ActionList actions = new ActionList();

        ArrayList<String> monologues = new ArrayList<>();
        monologues.add("The factory will never gonna give you up, valuable intern!");
        monologues.add("We promise we never gonna let you down with a range of staff benefits.");
        monologues.add("We never gonna run around and desert you, dear intern!");
        if (owner.getItemInventory().size() > 10){
            monologues.add("We never gonna make you cry with unfair compensation.");
        }
        if (owner.getBalance() > 50){
            monologues.add("Trust is essential in this business. We promise we never gonna say goodbye to a valuable intern like you.");
        }
        if (owner.getAttribute(BaseActorAttributes.HEALTH) < 2){
            monologues.add("Don't worry, we never gonna tell a lie and hurt you, unlike those hostile creatures.");
        }

        String monologue = monologues.get(random.nextInt(monologues.size()));
        actions.add(new MonologueAction(this.toString(), monologue));

        return actions;
    }
}
