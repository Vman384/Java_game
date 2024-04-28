package game.objects.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.abstractions.item.PrintableItem;
import game.abstractions.spawnable.Spawnable;
import game.objects.ground.ComputerTerminal;
import game.utility.Probability;

public class ToiletRoll extends Item implements PrintableItem {
    private int creditCost;
    /***
     * Constructor.
     */
    public ToiletRoll() {
        super("Toilet Paper Roll", 's', true);
        this.creditCost = 5;
    }

    @Override
    public String print(Actor actor, ComputerTerminal printGround) {
        int dummyCost = this.creditCost;

        if (Probability.generateBoolean(0.75)) {
            dummyCost = 1;
        }

        if (actor.getBalance() >= dummyCost) {
            actor.addItemToInventory(this);
            actor.deductBalance(dummyCost);
            return actor + " has purchased " + this + " from " + printGround + " for " + dummyCost + " credits.";
        } else {
            return "Transaction failed, " + actor + " does not have " + dummyCost + " credits to purchase " + this + " from " + printGround;
        }
    }
}
