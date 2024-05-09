package game.objects.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.abstractions.item.PrintableItem;
import game.action.AttackAction;
import game.objects.ground.ComputerTerminal;
import game.utility.PrintValidation;
import game.utility.Probability;

/**
 * DragonSlayerSword class which represents a dragon slayer sword which is an item some actors can possess.
 *
 * @author Dean Mascitti
 */
public class DragonSlayerSword extends WeaponItem implements PrintableItem {
    private int creditCost;
    private double errorProbability;
    /**
     * Constructor.
     *
     */
    public DragonSlayerSword() {
        super("Dragon Slayer Sword", 'x', 50, "slices", 75);
        this.creditCost = 100;
        this.errorProbability = 0.5;
    }

    /**
     * Print method which implements the dragons slayer swords printing to player inventory functionality.
     *
     * @param actor The actor doing the print action
     * @param printGround the ground type printing the item
     * @return string describing the outcome of the print
     */
    @Override
    public String print(Actor actor, ComputerTerminal printGround) {
        if (Probability.generateBoolean(this.errorProbability)) {
            actor.deductBalance(this.creditCost);
            return "Error! There has been an error in the " + printGround + " and the " + actor + " has lost " + this.creditCost + " credits.";
        }

        return PrintValidation.validatePrinting(this.creditCost, this, actor, printGround);

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

    /**
     * Getter for the cost of the dragon slayer sword.
     *
     * @return cost of dragon slayer sword as an int
     */
    @Override
    public int getCost() {
        return this.creditCost;
    }
}
