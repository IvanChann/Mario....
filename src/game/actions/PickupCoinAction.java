package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Coin;
import game.managers.WalletManager;

/**
 * A class representing the action of picking up a coin
 * @author Andy Ouyang
 */
public class PickupCoinAction extends PickUpItemAction {
    /**
     * The coin to be picked up
     */
    private Coin coin;

    /**
     * Constructor, stores the coin
     * @param coin
     */
    public PickupCoinAction(Coin coin) {
        super(coin);
        this.coin = coin;
    }

    /**
     * Method used by the engine to perform the action of picking up a coin. It will add the value of the coin
     * to the balance in the wallet, then it will remove the coin from the map
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return  A string indicating that the coin has been picked up
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        WalletManager.getInstance().addCredit(coin.getValue());
        map.locationOf(actor).removeItem(coin);
        return actor + " picked up the " + coin + "($" + coin.getValue() + ")";
    }

    /**
     * Displays the option of picking up a coin with some value
     * @param actor The actor performing the action.
     * @return A string indicating that the coin of some value can be picked up
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " picks up the " + coin + "($" + coin.getValue() + ")";
    }
}
