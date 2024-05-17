package game.items.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.items.actions.Purchasable;
import game.items.actions.Monologuable;
import game.items.actions.MonologueAction;

/**
 * A class that represents an AI Device in the game known as Astley.
 */
public class AIDevice extends Item implements Purchasable, Monologuable{
    private final int cost;
    private final int subscriptionFee;
    private int counter;
    private boolean isActive;

    public AIDevice() {
        super("Astley", 'z', true);
        this.counter = 0;
        this.cost = 50;
        this.subscriptionFee = 1;
        this.isActive = false;
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

    @Override
    public void tick(Location currentLocation, Actor actor) {
        counter++;
        if((counter % 5 == 0)){
            if (actor.getBalance() >= subscriptionFee){
                actor.deductBalance(subscriptionFee);
                isActive = true;
            } else {
                isActive = false;
            }
        }
        super.tick(currentLocation, actor);
        // awaiting specifications on how to count ticks and when subscription is active from ED
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
        if (isActive) {
            actions.add(getMonologueOptions(owner));
        }
        return actions;
    }

    @Override
    public ActionList getMonologueOptions(Actor owner){
        ActionList actions = new ActionList();
        actions.add(new MonologueAction(this.toString(), "The factory will never gonna give you up, valuable intern!"));
        actions.add(new MonologueAction(this.toString(), "We promise we never gonna let you down with a range of staff benefits."));
        actions.add(new MonologueAction(this.toString(), "We never gonna run around and desert you, dear intern!"));
        if (owner.getItemInventory().size() > 10){
            actions.add(new MonologueAction(this.toString(), "We never gonna make you cry with unfair compensation."));
        }
        if (owner.getBalance() > 50){
            actions.add(new MonologueAction(this.toString(), "Trust is essential in this business. We promise we never gonna say goodbye to a valuable intern like you."));
        }
        if (owner.getAttribute(BaseActorAttributes.HEALTH) < 2){
            actions.add(new MonologueAction(this.toString(), "Don't worry, we never gonna tell a lie and hurt you, unlike those hostile creatures."));
        }
        return actions;
    }
}
