package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.abstractions.item.Monolouge;

/**
 * The action for when a class needs to monologue
 * @author Vedansh Malhan
 * 
 */
public class MonolougeAction extends Action{
        private Monolouge monolouge;

    /**
     * Constructor.
     *
     * @param monologue the item that can display a monologue
     */
    public MonolougeAction(Monolouge monolouge) {
        this.monolouge = monolouge;
    }

    /**
     * Executes the Monologue action, causing the monologue method to be called
     *
     * @param actor the actor performing the action
     * @param map   the game map where the action is taking place
     * @return a message describing the result of the action
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        monolouge.monologue();
        return "";
    }

    /**
     * Provides a description of the action for displaying in menus or logs.
     *
     * @param actor the actor performing the action
     * @return a description of the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " listens to monologue from " + monolouge.getClass().getSimpleName();
    }
}
