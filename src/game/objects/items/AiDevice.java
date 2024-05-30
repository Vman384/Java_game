package game.objects.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import game.abstractions.item.Monolouge;
import game.abstractions.item.Printable;
import game.abstractions.item.SubscriptionItem;
import game.action.MonolougeAction;
import game.objects.ground.ComputerTerminal;
import game.utility.PrintValidation;
import game.utility.Probability;

import java.util.ArrayList;

/**  Class representing an AI Device that can be subscribed to, printed and provides monologues
* @author Vedansh Malhan
*/

public class AiDevice extends SubscriptionItem implements Printable, Monolouge {

    // The cost of subscribing to the AI Device
    private static final int SUBSCRIPTION_FEE = 1;

    // The length of the subscription period
    private static final int SUBSCRIPTION_LENGTH = 5;

    // The frequency of subscription action
    private static final int SUBSCRIPTION_OCCURANCE = 1;

    // The cost of the AI Device
    private static final int CREDIT_COST = 50;

    private static final int ITEM_MONOLOGUE_OPTION = 10;
    private static final int BALANCE_MONOLOGUE_OPTION = 50;
    private static final int HEALTH_MONOLOGUE_OPTION = 2;
    

    // A list of possible monologues for the AI Device
    private ArrayList<String> MonolougeOptions = new ArrayList<String>();

    /**
     * Constructor for the AiDevice class.
     * Initializes the AI Device with a name, symbol, and subscription details.
     */
    public AiDevice() {
        super("Astley", 'z', true,SUBSCRIPTION_FEE,SUBSCRIPTION_LENGTH,SUBSCRIPTION_OCCURANCE);
    }

    /**
     * Print method which implements the Ai Device printing to player inventory functionality.
     * Validates the printing action and returns a string describing the outcome of the print.
     *
     * @param actor       The actor doing the print action
     * @param printGround the ground type printing the item
     * @return String describing the outcome of the print
     */
    @Override
    public String print(Actor actor, ComputerTerminal printGround) {
        return PrintValidation.validatePrinting(CREDIT_COST, this, actor, printGround);
    }

    /**
     * Getter for the cost of the AI Device.
     *
     * @return Cost of the AI Device as an int
     */
    @Override
    public int getCost() {
        return CREDIT_COST;
    }

    /**
     * Generates a list of allowable actions for this consumable, which includes the action to consume it.
     *
     * @param owner the actor who owns or holds the item
     * @return list of allowable actions
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actionList = super.allowableActions(owner);
        if(super.SubscriptionActive){
            actionList.add(new MonolougeAction(this));
        }
        return actionList;
    }

    /**
     * Performs the subscription action for the AI Device, adding a new monologue to the list of options.
     *
     * @param actor the actor performing the subscription action
     */
    @Override
    public void subscriptionAction(Actor actor) {
        this.MonolougeOptions.add("The factory will never gonna give you up, valuable intern!");
        this.MonolougeOptions.add("We promise we never gonna let you down with a range of staff benefits.");
        this.MonolougeOptions.add("We never gonna run around and desert you, dear intern!");
        if(actor.getItemInventory().size()>=ITEM_MONOLOGUE_OPTION){
            this.MonolougeOptions.add("We never gonna make you cry with unfair compensation.");
        }
        if(actor.getBalance()>=BALANCE_MONOLOGUE_OPTION){
            this.MonolougeOptions.add("Trust is essential in this business. We promise we never gonna say goodbye to a valuable intern like you.");

        }
        if(actor.getAttribute(BaseActorAttributes.HEALTH)<=HEALTH_MONOLOGUE_OPTION){
            this.MonolougeOptions.add("Don't worry, we never gonna tell a lie and hurt you, unlike those hostile creatures.");
        }
    }

    /**
     * Chooses a random monologue from the list of options and prints it to the display.
     */
    public void monologue(){
        String toPrint = Probability.pickRandom(this.MonolougeOptions);
        Display display = new Display();
        display.print(toPrint);
    }
}