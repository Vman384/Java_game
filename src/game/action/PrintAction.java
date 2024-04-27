package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.abstractions.ground.SpawnerGround;
import game.abstractions.item.PrintableItem;

public class PrintAction extends Action {
    private PrintableItem itemPrinted;
    private SpawnerGround spawnGround;

    public PrintAction(PrintableItem itemPrinted, SpawnerGround spawnGround) {
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
