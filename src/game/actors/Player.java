package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.GameMap;
import game.displays.FancyMessage;

/**
 * Class representing the Player.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * @author chinweihan
 */
public class Player extends Actor {
    /**
     * Constructor.
     *
     * @param name        Name to call the player in the UI
     * @param displayChar Character to represent the player in the UI
     * @param hitPoints   Player's starting number of hitpoints
     */
    public Player(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.HOSTILE_TO_ENEMY);
    }

    /**
     * Select and return an action to perform on the current turn.
     *
     * @see Actor#playTurn(ActionList, Action, GameMap, Display) 
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the Action to be performed
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // Handle multi-turn Actions
        if (lastAction.getNextAction() != null)
            return lastAction.getNextAction();

        // return/print the console menu
        Menu menu = new Menu(actions);
        display.println(prettyPrint());
        return menu.showMenu(this, display);
    }

    /**
     * Returns a new collection of the Actions that the otherActor can do to the current Actor.
     *
     * @see Actor#allowableActions(Actor, String, GameMap)
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A collection of Actions.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_PLAYER)){
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }

    /**
     * Pretty prints the player name and current health.
     * A single-line version is already implemented for Actor.toString().
     *
     * @return String representing the state of the player.
     */
    public String prettyPrint() {
        int currHealth = this.getAttribute(BaseActorAttributes.HEALTH);
        int maxHealth = this.getAttributeMaximum(BaseActorAttributes.HEALTH);
        String res = "";
        res += name + "\n";
        res += String.format("HP: %d/%d",currHealth,maxHealth);
        return res;
    }

    /**
     * Method that can be executed when the actor is unconscious due to the action of another actor
     *
     * @param actor the perpetrator
     * @param map where the actor fell unconscious
     * @return a string describing what happened when the actor is unconscious
     */
    @Override
    public String unconscious(Actor actor, GameMap map) {
        String result = super.unconscious(actor, map);
        result += "\n" + FancyMessage.YOU_ARE_FIRED;
        return result;
    }
}
