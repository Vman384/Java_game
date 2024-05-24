package game.abstractions.item;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;

public abstract class SubscriptionItem extends Item {
    // The subscription fee for the item
    private int SubscriptionFee;

    // The length of the subscription period
    private int SubscriptionLength;

    // A boolean indicating whether the subscription is currently active
    protected boolean SubscriptionActive;

    // The number of ticks
    private int SubscriptionCount;

    // The number of turns between each subscription action
    private int SubscriptionOccurance;

    /**
     * Constructs a new SubscriptionItem with the given name, display character,
     * portability, subscription fee, subscription length, and subscription
     * occurrence.
     *
     * @param Name
     *            The name of the item
     * @param DisplayChar
     *            The character used to display the item on the map
     * @param Portable
     *            A boolean indicating whether the item can be carried by an
     *            actor
     * @param SubscriptionFee
     *            The subscription fee for the item
     * @param SubscriptionLength
     *            The length of the subscription period
     * @param SubscriptionOccurance
     *            The number of turns between each subscription action
     */
    public SubscriptionItem(String Name, char DisplayChar, boolean Portable,
            int SubscriptionFee, int SubscriptionLength, int SubscriptionOccurance) {
        super(Name, DisplayChar, Portable);
        this.SubscriptionActive = true;
        this.SubscriptionFee = SubscriptionFee;
        this.SubscriptionLength = SubscriptionLength;
        this.SubscriptionCount = 0;
        this.SubscriptionOccurance = SubscriptionOccurance;
    }

    /**
     * Charges the actor's balance for the subscription fee and updates the
     * subscription status.
     *
     * @param actor
     *            The actor to charge for the subscription
     */
    public void subscription(Actor actor) {
        if (this.SubscriptionActive) {
            if (actor.getBalance() >= this.SubscriptionFee) {
                actor.deductBalance(this.SubscriptionFee);
                this.SubscriptionActive = true;
            } else {
                this.SubscriptionActive = false;
            }
        } else {
            if (actor.getBalance() >= this.SubscriptionFee) {
                actor.deductBalance(this.SubscriptionFee);
                this.SubscriptionActive = true;
            } 
        }
    }

    /**
     * Performs the action associated with the subscription.
     *
     * @param actor The actor performing the subscription action
     */
    public void subscriptionAction(Actor actor) {
        actor.deductBalance(SubscriptionFee);
    }

    /**
     * Updates the subscription status and performs the subscription action if
     * necessary.
     *
     * This method is called once per turn, if the Item is being carried.
     *
     * @param currentLocation
     *            The location of the actor carrying this Item.
     * @param actor
     *            The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (this.SubscriptionCount % this.SubscriptionLength == 0 & this.SubscriptionCount != 0) {
            subscription(actor);
        }
        if (this.SubscriptionCount % this.SubscriptionOccurance == 0 && this.SubscriptionActive) {
            subscriptionAction(actor);
        }
        this.SubscriptionCount += 1;
    }
}