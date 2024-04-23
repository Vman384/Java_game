package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.abstractions.item.ConsumableItem;

/**
 * A class representing an action where an actor consumes a consumable item.
 * Created by:
 *
 * @author Weize Yu
 */
public class ConsumeAction extends Action {
    private ConsumableItem consumable;

    /**
     * Constructor.
     *
     * @param consumable the consumable item to be consumed
     */
    public ConsumeAction(ConsumableItem consumable) {
        this.consumable = consumable;
    }

    /**
     * Executes the consume action, causing the actor to consume the consumable item.
     *
     * @param actor the actor performing the action
     * @param map   the game map where the action is taking place
     * @return a message describing the result of the action
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return consumable.consume(actor);
    }

    /**
     * Provides a description of the action for displaying in menus or logs.
     *
     * @param actor the actor performing the action
     * @return a description of the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + consumable;
    }
}
