package game.objects.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.abstractions.item.Consumable;
import game.action.ConsumeAction;
import game.utility.Probability;

public class JarOfPickles extends Item implements Consumable {

    private int healAmount = 1;
    private int hurtAmount = 1;
    private double healProbability;

    /**
     * Constructor.
     */
    public JarOfPickles() {
        super("Jar of Pickles", 'n', true);
        this.healProbability = 0.5;
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

    /**
    * adds a balance of money value to the actors wallet
    *
    * @param actor the actor consuming the item
    * @return a message indicating the result of the consumption
    */
    @Override   
    public String consume(Actor actor) {
        if (Probability.generateBoolean(this.healProbability)){
            actor.heal(healAmount);
            actor.removeItemFromInventory(this);
            return actor + " consumes " + this + ". Health increased by " + healAmount + "!";
        }else{
            actor.hurt(hurtAmount);
            actor.removeItemFromInventory(this);
            return actor + " consumes " + this + " and was out of date, hurt by " + this.hurtAmount + "!";
        }
        
    }
}
