package game.objects.ground;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import game.abstractions.item.Consumable;
import game.action.AddHealthAction;
import game.action.ConsumeAction;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;



/**
 * Represents a puddle on the ground in the game world.
 * Puddles are represented by the '~' character.
 * Created by:
 *
 * @author Riordan D. Alfredo
 * Modified by:
 * @author Weize Yu
 */
public class Puddle extends Ground implements Consumable {
    private int healthIncrease = 1;
    /**
     * Constructor for Puddle objects.
     */
    public Puddle() {
        super('~');
    }
    /**
     * Generates a list of allowable actions for this consumable, which includes the action to consume it.
     *
     * @param actor the actor who owns or holds the item
     * @param location the location of the puddle
     * @param direction direction to actor
     * @return list of allowable actions
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actionList = new ActionList();
        if(location.containsAnActor()){
            actionList.add(new ConsumeAction(this));
        }
        return actionList;

    }

    /**
     * Applies the consumption effect of this consumable item to the given actor.
     *
     * @param actor the actor consuming the item
     * @return a message indicating the result of the consumption
     */
    public String consume(Actor actor) {
        actor.modifyAttributeMaximum(BaseActorAttributes.HEALTH, ActorAttributeOperations.INCREASE,this.healthIncrease);
        return actor + " Health increased by " + this.healthIncrease + "!";
    }


}
