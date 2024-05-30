package game.action.buying;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.buying.modifiers.BuyingModifiers;

/**
 * An action to buy an item from another actor.
 */
public class BuyAction extends Action {

    private final Item item;
    private final Actor buyer;
    private final Iterable<BuyingModifiers> modifiers;

    /**
     * Constructor.
     *
     * @param item       the item to be bought
     * @param buyer      the actor buying the item
     * @param modifiers  the buying modifiers to be applied
     */
    public BuyAction(Item item, Actor buyer, Iterable<BuyingModifiers> modifiers) {
        this.item = item;
        this.buyer = buyer;
        this.modifiers = modifiers;
    }

    /**
     * Perform the Action.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened (the result of the action being performed) that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        StringBuilder result = new StringBuilder();

        for (BuyingModifiers modifier : modifiers) {
            result.append(modifier.execute(buyer, actor, item, map)).append(" ");
        }

        return result.toString().trim();
    }

    /**
     * Describe what action will be performed if this Action is chosen in the menu.
     *
     * @param actor The actor performing the action.
     * @return the action description to be displayed on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        StringBuilder description = new StringBuilder();
        description.append(actor).append(" sells ").append(item).append(" to ").append(buyer).append(" ");

        for (BuyingModifiers modifier : modifiers) {
            description.append(modifier.description()).append(" ");
        }

        return description.toString().trim();
    }
}
