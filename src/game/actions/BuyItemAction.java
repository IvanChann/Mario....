package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Purchasable;
import game.managers.WalletManager;

public class BuyItemAction extends Action {
    private Purchasable item;
    private Integer price;

    public BuyItemAction(Purchasable item, Integer price){
        this.item = item;
        this.price = price;

    }
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


    @Override
    public String menuDescription(Actor actor) {
        return actor + " buys " + item + "($" + price + ")";
    }
}
