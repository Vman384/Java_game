package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.abstractions.item.PrintableItem;
import game.objects.ground.ComputerTerminal;

public class PrintAction extends Action {
    private PrintableItem itemPrinted;
    private ComputerTerminal printGround;

    public PrintAction(PrintableItem itemPrinted, ComputerTerminal printGround) {
        this.itemPrinted = itemPrinted;
        this.printGround = printGround;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return itemPrinted.print(actor, this.printGround);
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Print " + this.itemPrinted + " from " + this.printGround + " to " + actor + " inventory for " + itemPrinted.getCost() + " credits.";
    }
}
