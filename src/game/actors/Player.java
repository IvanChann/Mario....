package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import game.managers.WalletManager;
import game.statuses.Status;
import game.actions.ResetAction;
import game.reset.Resettable;

/**
 * Class representing the Player.
 */
public class Player extends Actor implements Resettable {

	private final Menu menu = new Menu();

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addCapability((Status.CAN_RESET));
		registerInstance();
	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		System.out.println("Mario" + this.printHp() + "  at (" + map.locationOf(this).x() + ", " + map.locationOf(this).y() +")");
		System.out.println("Wallet: $"+ WalletManager.getInstance().getBalance());
		if (this.hasCapability(Status.CAN_RESET)){
			actions.add(new ResetAction());
		}

		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	@Override
	public void hurt(int points) {		// overrode hurt method since if ANY damage is taken, removes TALL
		super.hurt(points);
		if (points > 0 && this.hasCapability(Status.TALL)){
			this.removeCapability(Status.TALL);
		}
	}

	@Override
	public char getDisplayChar(){
		return this.hasCapability(Status.TALL) ? Character.toUpperCase(super.getDisplayChar()): super.getDisplayChar();
	}

	@Override
	public boolean resetInstance(GameMap map) {
		if (this.hasCapability(Status.GLOWING)){
			this.removeCapability(Status.GLOWING);
		}
		if (this.hasCapability(Status.TALL)){
			this.removeCapability(Status.TALL);
		}
		this.heal(9999);

		return false;
	}
}
