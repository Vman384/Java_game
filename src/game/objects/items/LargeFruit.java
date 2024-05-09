package game.objects.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.abstractions.item.Consumable;
import game.abstractions.spawnable.Spawnable;
import game.action.ConsumeAction;

/**
 * A class representing a large fruit that inherits from Item and implements Spawnable.
 * Created by:
 *
 * @author Weize Yu
 */
public class LargeFruit extends Item implements Spawnable, Consumable {

    private final int healEffects = 2;
    /**
     * Constructor.
     */
    public LargeFruit() {
        super("Large Fruit", 'O', true);
    }

    /**
     * Spawns the fruit at the specified location.
     *
     * @param location the location where the fruit will be spawned
     */
    @Override
    public void spawn(Location location) {
        location.addItem(this);
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

    public String consume(Actor actor) {
        int prevHealth = actor.getAttribute(BaseActorAttributes.HEALTH);
        actor.heal(healEffects);
        actor.removeItemFromInventory(this);
        int newHealth = actor.getAttribute(BaseActorAttributes.HEALTH);

        if (prevHealth == actor.getAttributeMaximum(BaseActorAttributes.HEALTH)) {
            return actor + " consumes " + this + ". Health is already at maximum.";
        }

        int healthIncrease = newHealth - prevHealth;
        return actor + " consumes " + this + ". Health increased by " + healthIncrease + "!";
    }


}
