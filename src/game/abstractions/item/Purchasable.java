package game.abstractions.item;

import edu.monash.fit2099.engine.actors.Actor;
import game.objects.ground.ComputerTerminal;

/**
 * Printable interface which each class that can be printed implements.
 *
 * @author Dean Mascitti
 */
public interface Purchasable {

    /**
     * This method is overriden by each printable item in which their respective printing process can be implemented.
     *
     * @param actor       The actor doing the print action
     * @param printGround the ground type printing the item
     * @return A string displaying the outcome of the print
     */
    String print(Actor actor, ComputerTerminal printGround);

    /**
     * Getter for the cost of the item to be printed
     *
     * @return integer of the price of the item being printed
     */
    int getCost();
}
