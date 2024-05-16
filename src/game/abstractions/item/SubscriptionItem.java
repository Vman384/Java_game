package game.abstractions.item;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;

public abstract class SubscriptionItem extends Item {
    private int SubscriptionFee;
    private int SubscriptionLength;
    private boolean SubscriptionActive;
    private int SubscriptionCount;
    private int SubscriptionOccurance;

    public SubscriptionItem(String Name, char DisplayChar, boolean Portable, int SubscriptionFee, int SubscriptionLength, int SubscriptionOccurance){
        super(Name, DisplayChar, Portable);
        this.SubscriptionActive = false;
        this.SubscriptionFee = SubscriptionFee;
        this.SubscriptionLength = SubscriptionLength;
        this.SubscriptionCount = 0;
        this.SubscriptionOccurance = SubscriptionOccurance;

    }

    public String subscription(Actor actor){
        if(this.SubscriptionActive){
            if(actor.getBalance() >= this.SubscriptionFee){
                actor.deductBalance(this.SubscriptionFee);
                this.SubscriptionActive = true;
                return "continuing subscription";
            }else{
                this.SubscriptionActive = false;
                return "Subscription has ended after this period";
            }
        }else{
            if(actor.getBalance() >= this.SubscriptionFee){
                actor.deductBalance(this.SubscriptionFee);
                this.SubscriptionActive = true;
                return "restarting subscription";
            }else{
                return "Subscription is inactive";
            }
        }
    };

    public String subscriptionAction(Actor actor){
        return "executing subscription";
    }

    /**
	 * Inform a carried Item of the passage of time.
	 *
	 * This method is called once per turn, if the Item is being carried.
	 * @param currentLocation The location of the actor carrying this Item.
	 * @param actor The actor carrying this Item.
	 */
    @Override
	public void tick(Location currentLocation, Actor actor) {
        if(this.SubscriptionCount % this.SubscriptionLength == 0){
            subscription(actor);
        }
        if(this.SubscriptionCount % this.SubscriptionOccurance == 0 && this.SubscriptionActive){
            subscriptionAction(actor);
        }
        this.SubscriptionCount+=1;

	}

}
