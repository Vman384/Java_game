package game.objects.items;

import edu.monash.fit2099.engine.actors.Actor;
import game.abstractions.item.ConsumableItem;
import game.utility.Probability;

public class JarOfPickles extends ConsumableItem {

    private int healAmount = 1;
    private int hurtAmount = 1;

    /**
     * Constructor.
     */
    public JarOfPickles() {
        super("Jar of Pickles", 'n', true);
    }

    /**
    * adds a balance of money value to the actors wallet
    *
    * @param actor the actor consuming the item
    * @return a message indicating the result of the consumption
    */
    @Override   
    public String consume(Actor actor) {
        if (Probability.generateBoolean(0.5)){
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
