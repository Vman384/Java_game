package game.objects.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.abstractions.item.PrintableItem;
import game.abstractions.item.Teleportable;
import game.action.TeleportAction;
import game.objects.ground.ComputerTerminal;
import game.utility.PrintValidation;
import game.utility.Probability;


public class Teleporter extends Item implements PrintableItem, Teleportable {
    private int creditCost;
    private GameMap gameMap;
    private Actor actor;

    public Teleporter(GameMap gameMap) {
        super("THESEUS", '^', true);
        this.gameMap = gameMap;
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
    public void tick(Location location) {
        teleport(actor);
    }

    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actionList = new ActionList();
        System.out.println("Makes it here first obviously");
        actionList.add(new TeleportAction(this));
        return actionList;

        //if (location.getItems().contains(this)) {
            //System.out.println("Actually does make it here z!!!!");
            //actionList.add(new TeleportAction(this));
        //}
        //return actionList;
    }
    @Override
    public String teleport(Actor actor) {
        int xValue = Probability.pickRandomLocation(gameMap.getXRange());
        int yValue = Probability.pickRandomLocation(gameMap.getYRange());

        Location randomLocation = new Location(gameMap, xValue, yValue);

        if (!randomLocation.containsAnActor()) {
            gameMap.moveActor(actor, randomLocation);}
        else {teleport(actor);}
        return actor + " teleports to " + randomLocation;
        }

}
