package game.actors;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.actions.AttackAction;
import game.items.actions.SellAction;
import game.items.actions.Sellable;

import java.util.List;

public class HumanoidFigure extends NPC {

    public HumanoidFigure() {
        super("Humanoid Figure", 'H', Integer.MAX_VALUE);
        this.addCapability(Status.VENDOR);
    }



}
