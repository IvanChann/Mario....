package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Coin;
import game.managers.WalletManager;


public class PickupCoinAction extends PickUpItemAction {
    private Coin coin;

    public PickupCoinAction(Coin coin) {
        super(coin);
        this.coin = coin;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        WalletManager.getInstance().addCredit(coin.getValue());
        map.locationOf(actor).removeItem(coin);
        return actor + " picked up the " + coin + "($" + coin.getValue() + ")";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " picks up the " + coin + "($" + coin.getValue() + ")";
    }
}
