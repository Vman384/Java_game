package game.utility;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.objects.ground.ComputerTerminal;

public class PrintValidation {

    public static String validatePrinting(int itemCost, Item itemPrinted, Actor actor, ComputerTerminal printGround) {

        if (actor.getBalance() >= itemCost) {
            actor.addItemToInventory(itemPrinted);
            actor.deductBalance(itemCost);
            return actor + " has purchased " + itemPrinted + " from " + printGround + " for " + itemCost + " credits.";
        } else {
            return "Transaction failed, " + actor + " does not have " + itemCost + " credits to purchase " + itemPrinted + " from " + printGround;
        }
    }
}
