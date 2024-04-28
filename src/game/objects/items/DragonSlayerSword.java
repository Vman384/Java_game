package game.objects.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.abstractions.item.PrintableItem;
import game.action.AttackAction;
import game.objects.ground.ComputerTerminal;
import game.utility.Probability;

public class DragonSlayerSword extends WeaponItem implements PrintableItem {
    private int creditCost;
    /**
     * Constructor.
     *
     */
    public DragonSlayerSword() {
        super("Dragon Slayer Sword", 'x', 50, "slices", 75);
        this.creditCost = 100;
    }

    @Override
    public String print(Actor actor, ComputerTerminal printGround) {
        if (Probability.generateBoolean(0.5)) {
            actor.deductBalance(this.creditCost);
            return "Error! There has been an error in the " + printGround + " and the " + actor + " has lost " + this.creditCost + " credits.";
        }

        if (actor.getBalance() >= this.creditCost) {
            actor.addItemToInventory(this);
            actor.deductBalance(this.creditCost);
            return actor + " has purchased " + this + " from " + printGround + " for " + this.creditCost + " credits.";
        } else {
            return "Transaction failed, " + actor + " does not have " + this.creditCost + " credits to purchase " + this + " from " + printGround;
        }

    }

    /**
     * Generates a list of allowable actions for using the Dragon Slayer Sword as a weapon.
     *
     * @param otherActor the actor being targeted for attack
     * @param location   the location where the attack is taking place
     * @return a list of allowable actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actionList = new ActionList();
        actionList.add(new AttackAction(otherActor, location.toString(), this));
        return actionList;
    }
}
