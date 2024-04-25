package game.objects.items;

import edu.monash.fit2099.engine.actors.Actor;
import game.abstractions.item.ConsumableItem;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import game.utility.Probability;

public class JarofPickles extends ConsumableItem {

    int healAmount = 1;
    int hurtAmount = 1;

    /**
     * Constructor.
     */
    public JarofPickles() {
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
            int prevHealth = actor.getAttribute(BaseActorAttributes.HEALTH);
            actor.heal(healAmount);
            actor.removeItemFromInventory(this);
            int newHealth = actor.getAttribute(BaseActorAttributes.HEALTH);

            if (prevHealth == actor.getAttributeMaximum(BaseActorAttributes.HEALTH)) {
                return actor + " consumes " + this + ". Health is already at maximum.";
            }

            int healthIncrease = newHealth - prevHealth;
            return actor + " consumes " + this + ". Health increased by " + healthIncrease + "!";
        }else{
            actor.hurt(hurtAmount);
            actor.removeItemFromInventory(this);
            return actor + " consumes " + this + " and was out of date, hurt by " + hurtAmount + "!";
        }
        
    }
}
