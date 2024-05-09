package game.objects.ground;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.abstractions.item.PrintableItem;
import game.action.PrintAction;
import java.util.List;

/**
 * ComputerTerminal class which represents a terminal that has the capability to print items to the players inventory
 *
 * @author Dean Mascitti
 */
public class ComputerTerminal extends Ground {
    private List<PrintableItem> printingOptions;

    /**
     * Class Constructor.
     *
     * @param printingOptions a list of all the printable items of the terminal
     */
    public ComputerTerminal(List<PrintableItem> printingOptions) {
        super('=');
        this.printingOptions = printingOptions;
    }


    /**
     * Returns an Action list containing all print actions for printable items.
     *
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return a new, empty collection of Actions
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction){
        ActionList actions = new ActionList();
        for (PrintableItem printableItem : printingOptions) {
            actions.add(new PrintAction(printableItem, this));
        }

        return actions;
    }

    /**
     * Method for printing class name.
     *
     * @return String of computer terminal
     */
    @Override
    public String toString() {
        return "Computer Terminal";
    }
}
