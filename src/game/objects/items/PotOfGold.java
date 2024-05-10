package game.objects.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.abstractions.item.Consumable;
import game.action.ConsumeAction;

/**
 * Represents a pot of gold which can be consumed by the actor
 * to add a balance of moneyValue to the actor
 * Created by:
 * @author Vedansh Malhan
 */
public class PotOfGold extends Item implements Consumable {

    private int moneyValue = 10;

    /**
     * Constructor.
     */
    public PotOfGold() {
        super("Pot of Gold", '$', true);
    }


    /**
     * Generates a list of allowable actions for this consumable, which includes the action to consume it.
     *
     * @param owner the actor who owns or holds the item
     * @return list of allowable actions
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actionList = new ActionList();
        actionList.add(new ConsumeAction(this));
        return actionList;
    }

    /**
     * adds a balance of money value to the actors wallet
     *
     * @param actor the actor consuming the item
     * @return a message indicating the result of the consumption
     */
    @Override
    public String consume(Actor actor) {
        actor.addBalance(moneyValue);
        actor.removeItemFromInventory(this);
        return "added  $" + moneyValue + " to your balance.";
    }
}
