package game.behaviour;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.constants.Status;
import game.utility.Probability;

import java.util.ArrayList;

/**
 * A behavior subclass representing following and wandering behavior for an actor.
 */
public class FollowAndWanderBehaviour implements Behaviour {
    private final Behaviour wanderBehaviour = new WanderBehaviour();

    /**
     * Constructor for FollowAndWanderBehaviour.
     */
    public FollowAndWanderBehaviour() {
        super();
    }

    /**
     * Retrieves the action for the actor based on the follow and wander behavior.
     *
     * @param actor the actor whose action is to be determined
     * @param map   the current game map
     * @return the action to be performed by the actor
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        ArrayList<Action> actions = new ArrayList<>();
        Location actorLocation = map.locationOf(actor);

        // Check if intern is within 1 exit of the actor
        for (Exit exit : actorLocation.getExits()) {
            Location destination = exit.getDestination();
            // Check if Intern now that intern has moved away, due to player game order
            for (Exit innerExit : destination.getExits()) {
                Location innerDestination = innerExit.getDestination();
                if (containsIntern(innerDestination)) {
                    // move towards intern
                    actions.add(destination.getMoveAction(actor, "towards intern", innerExit.getHotKey()));
                }
            }
        }

        // in case of multiple interns
        if (!actions.isEmpty()) {
            return Probability.pickRandom(actions);
        }

        // If not within follow range or intern is not reachable, perform wandering behavior
        return wanderBehaviour.getAction(actor, map);
    }

    /**
     * Determines whether a location contains an intern.
     *
     * @param location the location to check
     * @return true if the location contains an intern, false otherwise
     */
    private boolean containsIntern(Location location) {
        if (location.containsAnActor()) {
            Actor actor = location.getActor();
            return actor.hasCapability(Status.INTERN);
        }
        return false;
    }
}
