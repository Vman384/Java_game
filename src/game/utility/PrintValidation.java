package game.utility;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.objects.ground.ComputerTerminal;

/**
 * PrintValidation class contains the functionality for checking whether a print can occur and then executes the print.
 *
 * @author Dean Mascitti
 */
public class PrintValidation {

    /**
     * Static method in which checks if an actor has funds to puchase item and then prints the item if so.
     *
     * @param itemCost Cost of the item
     * @param itemPrinted Item being printed
     * @param actor Actor purchasing item
     * @param printGround Ground printing the item
     * @return A string describing the result of the print.
     */
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
