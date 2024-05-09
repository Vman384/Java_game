package game.objects.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import game.abstractions.item.Consumable;
import game.abstractions.item.PrintableItem;
import game.action.ConsumeAction;
import game.objects.ground.ComputerTerminal;
import game.utility.PrintValidation;
import game.utility.Probability;

public class EnergyDrink extends Item implements PrintableItem, Consumable {
    private int creditCost;
    private final int healEffects = 1;
    private double costProbability;
    /**
     * Constructor for ConsumableItem subclass Energy Drink.
     *
     */
    public EnergyDrink() {
        super("Energy Drink", '*', true);
        this.creditCost = 10;
        this.costProbability = 0.2;
    }

    /**
     * Print method which implements the energy drinks printing to player inventory functionality.
     *
     * @param actor The actor doing the print action
     * @param printGround the ground type printing the item
     * @return
     */
    @Override
    public String print(Actor actor, ComputerTerminal printGround) {
        int dummyCost = this.creditCost;

        if (Probability.generateBoolean(this.costProbability)) {
            dummyCost = 2 * this.creditCost;
        }

        return PrintValidation.validatePrinting(dummyCost, this, actor, printGround);

    }

    /**
     * Getter for cost of energy drink.
     *
     * @return cost of energy drink as an int.
     */
    @Override
    public int getCost() {
        return this.creditCost;
    }

    /**
     * Generates a list of allowable actions for this consumable, which includes the action to consume it.
     *
     * @param owner the actor who owns or holds the item
     * @return list of allowable actions
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actionList = new ActionList();
        actionList.add(new ConsumeAction(this));
        return actionList;
    }

    /**
     * Applies the consumption effect of this consumable item to the given actor.
     *
     * @param actor the actor consuming the item
     * @return a message indicating the result of the consumption
     */
    public String consume(Actor actor) {
        int prevHealth = actor.getAttribute(BaseActorAttributes.HEALTH);
        actor.heal(healEffects);
        actor.removeItemFromInventory(this);
        int newHealth = actor.getAttribute(BaseActorAttributes.HEALTH);

        if (prevHealth == actor.getAttributeMaximum(BaseActorAttributes.HEALTH)) {
            return actor + " consumes " + this + ". Health is already at maximum.";
        }

        int healthIncrease = newHealth - prevHealth;
        return actor + " consumes " + this + ". Health increased by " + healthIncrease + "!";
    }

}
