package game.items.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.items.fruits.Consumable;
import game.items.fruits.ConsumeAction;

import java.util.Random;

public class JarOfPickles extends Item implements Consumable {
    private final Random rand = new Random();
    private final int expireChance;
    private final int healAmount;
    private final int damageAmount;

    public JarOfPickles() {
        super("Jar of Pickles", 'n', true);
        this.expireChance = 50;
        this.healAmount = 1;
        this.damageAmount = 1;
    }

    private boolean isExpired(){
        return rand.nextInt(100) <= expireChance;
    }

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
