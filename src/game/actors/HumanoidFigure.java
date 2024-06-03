package game.actors;

/**
 * A class representing the HumanoidFigure
 */
public class HumanoidFigure extends NPC {

    public HumanoidFigure() {
        super("Humanoid Figure", 'H', Integer.MAX_VALUE);
        this.addCapability(Status.SELLABLE_TOWARDS);
    }
}
