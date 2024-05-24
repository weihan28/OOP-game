package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.actions.AttackAction;
import game.behaviours.WanderBehaviour;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class Monster extends Actor{
    protected Map<Integer, Behaviour> behaviours = new TreeMap<>();

    public Monster(String name, char displayChar, int hitpoints) {
       super(name, displayChar, hitpoints);
        this.behaviours.put(50, new WanderBehaviour());
    }
    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * The monster can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }

    /**
     * Method that can be executed when the Monster is unconscious due to the action of another actor. Also drops all items from inventory.
     * @param actor the perpetrator
     * @param map where the actor fell unconscious
     * @return a string describing what happened when the actor is unconscious
     */
    @Override
    public String unconscious(Actor actor, GameMap map) {
        String dropRes = dropAllItems(map);
        String unconsciousRes = super.unconscious(actor, map);
        return String.format("%s\n%s", unconsciousRes, dropRes);
    }

    /**
     * Drops all the inventory items of this monster when called.
     * Prerequisite: this monster still exists on the map.
     * @param map the game map that the monster is in.
     * @return String menu description of the dropped items.
     */
    private String dropAllItems(GameMap map) {
        ArrayList<String> droppedRes = new ArrayList<>();
        List<Item> items = List.copyOf(getItemInventory());
        for (Item item : items) {
            droppedRes.add(item.getDropAction(this).execute(this, map));
        }
        return String.join("\n", droppedRes);
    }

}
