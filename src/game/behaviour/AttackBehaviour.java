package game.behaviour;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.AttackAction;
import game.constants.Status;
import game.utility.Probability;

import java.util.ArrayList;
import java.util.List;

/**
 * A behaviour for attacking hostile actors adjacent to the actor.
 * Created by:
 *
 * @author Weize Yu
 */
public class AttackBehaviour implements Behaviour {

    /**
     * Returns an AttackAction if there is a hostile actor adjacent to the actor.
     *
     * @param actor the Actor acting
     * @param map   the GameMap containing the Actor
     * @return an AttackAction if there is a hostile actor adjacent to the actor, null otherwise.
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        // Create a list to store potential AttackActions
        List<Action> actions = new ArrayList<>();

        for (Exit exit : map.locationOf(actor).getExits()) {
            Actor otherActor = exit.getDestination().getActor();
            if (otherActor == null) {
                continue;
            }
            if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                actions.add(new AttackAction(otherActor, exit.getDestination().toString(), actor.getIntrinsicWeapon()));
            }
        }

        if (actions.isEmpty()) {
            return null;
        }

        return Probability.pickRandom(actions);
    }
}
