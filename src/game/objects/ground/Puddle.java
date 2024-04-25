package game.objects.ground;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import game.abstractions.item.ConsumableItem;
import game.action.AddHealthAction;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;



/**
 * Represents a puddle on the ground in the game world.
 * Puddles are represented by the '.' character.
 * Created by:
 *
 * @author Riordan D. Alfredo
 * Modified by:
 *
 * @author Weize Yu
 */
public class Puddle extends Ground {
    int healthIncrease = 1;
    /**
     * Constructor for Puddle objects.
     */
    public Puddle() {
        super('~');
    }

    /**
	 * Returns an Action list that has the AddHealthAction
	 *
	 * @param actor the Actor acting
	 * @param location the current Location
	 * @param direction the direction of the Ground from the Actor
	 * @return a new, empty collection of Actions
	 */
    @Override
	public ActionList allowableActions(Actor actor, Location location, String direction){
		ActionList actions = super.allowableActions(actor, location, direction);
        if(location.containsAnActor()){
            actions.add(new AddHealthAction(healthIncrease));
        }
        return actions;
	}
}
