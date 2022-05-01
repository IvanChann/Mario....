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
	private final int initialHitPoints;

	/**
	 * Constructor. Makes player hostile to enemies, and allows the player to reset the game
	 * Stores the player's starting hit points
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hit points
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addCapability((Status.CAN_RESET));
		this.initialHitPoints = hitPoints;
		registerInstance();
	}

	/**
	 * Lets player chooses what action to perform each turn
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return console menu of all the actions that can be performed
	 */
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

	/**
	 * Takes an amount of the player's hitpoints away. Removes tall status if player takes damage
	 * @param points number of hitpoints to deduct.
	 */
	@Override
	public void hurt(int points) {
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
	public boolean resetInstance() {
		this.removeCapability(Status.GLOWING);
		this.resetMaxHp(initialHitPoints);
		this.removeCapability(Status.TALL);


		return false;
	}
}
