package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.abstractions.item.Printable;
import game.objects.ground.ComputerTerminal;

/**
 * PrintAction class gives the player the option to print an item into their inventory for a certain price.
 *
 * @author Dean Mascitti
 */
public class PrintAction extends Action {
    private Printable itemPrinted;
    private ComputerTerminal printGround;

    /**
     * Constructor.
     *
     * @param itemPrinted The item being printed
     * @param printGround The ground type in which is printing the item
     */
    public PrintAction(Printable itemPrinted, ComputerTerminal printGround) {
        this.itemPrinted = itemPrinted;
        this.printGround = printGround;
    }

    /**
     * Method which does the executyion of printing by calling the print method in the corresponding item being printed.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return String describing the outcome of the print
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return itemPrinted.print(actor, this.printGround);
    }

    /**
     * Method for displaying the action to the player.
     *
     * @param actor The actor performing the action.
     * @return String describing the print action.
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Print " + this.itemPrinted + " from " + this.printGround + " to " + actor + " inventory for " + itemPrinted.getCost() + " credits.";
    }
}
