package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Purchasable;
import game.managers.WalletManager;

/**
 *  This class represents the action of buying (purchasable) items
 * @author Andy Ouyang
 */
public class BuyItemAction extends Action {
    /**
     * The item to be purchased
     */
    private Purchasable item;
    /**
     * The price of the item
     */
    private Integer price;

    /**
     * Constructor. Stores the item and price as attributes
     * @param item Item to be bought
     * @param price Price of the item to be bought
     */
    public BuyItemAction(Purchasable item, Integer price){
        this.item = item;
        this.price = price;

    }

    /**
     * Method used by the engine to perform the purchasing process of a purchasable item.
     * If there is sufficient balance in the wallet, then the item will be added to the players inventory
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A string indicating whether the item has been bought or not
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        WalletManager wallet = WalletManager.getInstance();
        Integer currentBalance = wallet.getBalance();
        if (currentBalance >= price) {
            item.purchasedBy(actor);
            wallet.removeCredit(price);
            return item + " has been added to your inventory";
        }
        return "You don't have enough coins!";
    }

    /**
     * Displays the option of buying an item on the menu
     * @param actor The actor performing the action.
     * @return String representing that the item can be bought with sufficient credits
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " buys " + item + "($" + price + ")";
    }
}
