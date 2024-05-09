package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.GameMap;


public class AddHealthAction extends Action {
    private int healthIncrease;

    /**
     * Constructor.
     *
     * @param healthIncrease the amount to increase health by
     */
    public AddHealthAction(int healthIncrease) {
        this.healthIncrease = healthIncrease;
    }

    /**
     * Permanantly adds 1 health point to the actors max health
     *
     * @param actor the actor performing the action
     * @param map   the game map where the action is taking place
     * @return a message describing the result of the action
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        actor.modifyAttributeMaximum(BaseActorAttributes.HEALTH, ActorAttributeOperations.INCREASE, this.healthIncrease);
        return actor + " Health increased by " + this.healthIncrease + "!";
    }


    /**
     * Provides a description of the action for displaying in menus or logs.
     *
     * @param actor the actor performing the action
     * @return a description of the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return "increase " + actor + " health by " + this.healthIncrease;
    }
}

