package game.objects.ground;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.abstractions.item.PrintableItem;
import game.action.PrintAction;

import java.util.ArrayList;
import java.util.List;

public class ComputerTerminal extends Ground {
    List<PrintableItem> printingOptions;
    /**
     * Constructor for ComputerTerminal.
     *
     */
    public ComputerTerminal(List<PrintableItem> printingOptions) {
        super('=');
        this.printingOptions = printingOptions;
    }


    /**
     * Returns an Action list.
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
}
