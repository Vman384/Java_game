package game.objects.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import game.abstractions.item.SubscriptionItem;
import game.action.ConsumeAction;
import game.action.MonolougeAction;
import game.abstractions.item.Monolouge;
import game.abstractions.item.PrintableItem;
import game.objects.ground.ComputerTerminal;
import game.utility.PrintValidation;
import game.utility.Probability;

public class AiDevice extends SubscriptionItem implements PrintableItem, Monolouge {
    private static final int SUBSCRIPTION_FEE = 1;
    private static final int SUBSCRIPTION_LENGTH = 5;
    private static final int SUBSCRIPTION_OCCURANCE = 1;
    private static final int CREDIT_COST = 50;
    private ArrayList<String> MonolougeOptions = new ArrayList<String>();

    /***
     * Constructor.
     */
    public AiDevice() {
        super("Astley", 'z', true,SUBSCRIPTION_FEE,SUBSCRIPTION_LENGTH,SUBSCRIPTION_OCCURANCE);
    }

    /**
     * Print method which implements the toilet rolls printing to player inventory functionality.
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
        ActionList actionList = new ActionList();
        actionList.add(new MonolougeAction(this));
        return actionList;
    }


    @Override
    public String subscriptionAction(Actor actor) {
        this.MonolougeOptions.add("The factory will never gonna give you up, valuable intern!");
        this.MonolougeOptions.add("We promise we never gonna let you down with a range of staff benefits.");
        this.MonolougeOptions.add("We never gonna run around and desert you, dear intern!");
        if(actor.getItemInventory().size()>=10){
            this.MonolougeOptions.add("We never gonna make you cry with unfair compensation.");
        }
        if(actor.getBalance()>=50){
            this.MonolougeOptions.add("Trust is essential in this business. We promise we never gonna say goodbye to a valuable intern like you.");

        }
        if(actor.getAttribute(BaseActorAttributes.HEALTH)<=2){
            this.MonolougeOptions.add("Don't worry, we never gonna tell a lie and hurt you, unlike those hostile creatures.");
        }
        return "subscription ran";
    }

    public void monologue(){
        String toPrint = Probability.pickRandom(this.MonolougeOptions);
        Display display = new Display();
        display.print(toPrint);
    }
}
