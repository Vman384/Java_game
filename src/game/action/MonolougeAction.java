package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.abstractions.item.Monolouge;

public class MonolougeAction extends Action{
        private Monolouge monolouge;

    /**
     * Constructor.
     *
     * @param consumable the consumable item to be consumed
     */
    public MonolougeAction(Monolouge monolouge) {
        this.monolouge = monolouge;
    }

    /**
     * Executes the consume action, causing the actor to consume the consumable item.
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
