package game.objects.items;

import edu.monash.fit2099.engine.actors.Actor;
import game.abstractions.item.ConsumableItem;

public class PotofGold extends ConsumableItem {

    int moneyValue = 10;
    /**
     * Constructor.
     */
    public PotofGold() {
        super("Pot of Gold", '$', true);
    }

    /**
    * adds a balance of money value to the actors wallet
    *
    * @param actor the actor consuming the item
    * @return a message indicating the result of the consumption
    */
    @Override   
    public String consume(Actor actor) {
        actor.addBalance(moneyValue);
        actor.removeItemFromInventory(this);
        return "added  $" + moneyValue + " to your balance.";
    }
}
