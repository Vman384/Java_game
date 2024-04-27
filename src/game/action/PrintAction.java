package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.abstractions.ground.SpawnerGround;
import game.abstractions.item.PrintableItem;
import game.objects.ground.ComputerTerminal;

public class PrintAction extends Action {
    private PrintableItem itemPrinted;
    private ComputerTerminal spawnGround;

    public PrintAction(PrintableItem itemPrinted, ComputerTerminal spawnGround) {
        this.itemPrinted = itemPrinted;
        this.spawnGround = spawnGround;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        itemPrinted.print(actor);
        return this.itemPrinted + " printed to " + actor + " inventory.";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Print " + this.itemPrinted + " from " + this.spawnGround + " to " + actor + " inventory.";
    }
}
