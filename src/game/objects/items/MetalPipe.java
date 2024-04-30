package game.objects.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.action.AttackAction;
import game.constants.Status;

/**
 * Represents a metal pipe item in the game world.
 * Metal pipes can be used as weapons to attack other actors.
 * Created by:
 *
 * @author Weize Yu
 */
public class MetalPipe extends WeaponItem {

    /**
     * Constructor for MetalPipe objects.
     */
    public MetalPipe() {
        super("Metal Pipe", '!', 100, "hit", 100);
    }

    /**
     * Generates a list of allowable actions for using the metal pipe as a weapon.
     *
     * @param otherActor the actor being targeted for attack
     * @param location   the location where the attack is taking place
     * @return a list of allowable actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actionList = new ActionList();
        actionList.add(new AttackAction(otherActor, location.toString(), this));
        return actionList;
    }
}
