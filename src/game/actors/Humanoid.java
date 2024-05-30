package game.actors;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.abstractions.actor.NPC;
import game.action.buying.BuyActionGenerator;

/**
 * Represents a humanoid non-player character (NPC) in the game. Humanoids have the ability to engage in buying actions.
 */
public class Humanoid extends NPC {

    /**
     * The mechanism for generating buying actions for this Humanoid.
     */
    private final BuyActionGenerator buyingGeneration;

    /**
     * Creates a new Humanoid.
     *
     * @param buyingRules The rules governing how the Humanoid can buy items.
     */
    public Humanoid(BuyActionGenerator buyingRules) {
        super("Humanoid", 'H', 50);
        this.buyingGeneration = buyingRules;
    }

    /**
     * Returns a list of actions that the otherActor can perform on this Humanoid.
     * This includes any standard NPC actions as well as any generated buying actions.
     *
     * @param otherActor The Actor that might be performing an action.
     * @param direction  String representing the direction of the other Actor.
     * @param map        The current GameMap.
     * @return A list of allowable actions.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList prev = super.allowableActions(otherActor, direction, map);

        ActionList buyActions = buyingGeneration.generateBuyActions(this, otherActor, map);

        prev.add(buyActions);
        return prev;
    }

    /**
     * Creates a new instance of this Humanoid.
     *
     * Note: This method is currently not implemented and returns null. If you want to create copies of Humanoids,
     * you'll need to provide a specific implementation.
     *
     * @return A new instance of the Humanoid, or null if not implemented.
     */
    @Override
    protected NPC createNewInstance() {
        return new Humanoid(buyingGeneration);
    }
}
