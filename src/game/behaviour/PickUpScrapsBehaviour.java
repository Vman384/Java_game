package game.behaviour;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.constants.Status;
import game.utility.Probability;

import java.util.ArrayList;
import java.util.List;

/**
 * A behavior class representing the behavior of picking up scraps by an actor.
 */
public class PickUpScrapsBehaviour implements Behaviour {

    /**
     * Retrieves the action for the actor based on the behavior of picking up scraps.
     *
     * @param actor the actor whose action is to be determined
     * @param map   the current game map
     * @return the action to be performed by the actor, or null if no scraps are available to pick up
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location location = map.locationOf(actor);
        List<Item> items = location.getItems();

        if (items.isEmpty()) {
            return null;
        }

        List<Item> subset = new ArrayList<Item>();
        for (Item item : items) {
            if (item.hasCapability(Status.SCRAP)) {
                subset.add(item);
            }
        }

        if (subset.isEmpty()) {
            return null;
        }

        Item item = Probability.pickRandom(subset);

        return item.getPickUpAction(actor);
    }
}
