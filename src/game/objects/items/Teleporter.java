package game.objects.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.abstractions.item.PrintableItem;
import game.abstractions.item.Teleportable;
import game.action.TravelAction;
import game.objects.ground.ComputerTerminal;
import game.utility.PrintValidation;
import game.utility.Probability;


public class Teleporter extends Item implements PrintableItem, Teleportable {
    private final int creditCost;

    public Teleporter() {
        super("THESEUS", '^', true);
        this.creditCost = 100;

    }

    @Override
    public String print(Actor actor, ComputerTerminal printGround) {
        return PrintValidation.validatePrinting(this.creditCost, this, actor, printGround);
    }

    @Override
    public int getCost() {
        return this.creditCost;
    }

    @Override
    public ActionList allowableActions(Location location) {
        ActionList actionList = super.allowableActions(location);
        MoveActorAction teleportActor = new TravelAction(location, "", this);
        actionList.add(teleportActor);
        return actionList;

    }
    @Override
    public Location teleport(Actor actor, GameMap gameMap) {
        int xValue = Probability.pickRandomLocation(gameMap.getXRange());
        int yValue = Probability.pickRandomLocation(gameMap.getYRange());
        return gameMap.at(xValue, yValue);
        }

}
