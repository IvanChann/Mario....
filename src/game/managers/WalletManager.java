package game.managers;


/**
 * Singleton class representing the wallet system
 * @author Andy Ouyang
 */
public class WalletManager {
    private static WalletManager instance;
    /**
     * Amount of credits in the wallet
     */
    private int balance;

    /**
     * Private constructor
     */
    private WalletManager(){}

    /**
     * Returns the sole instance of WalletManager, or creates it and then returns it
     * @return the sole instance
     */
    public static WalletManager getInstance(){
        if (instance == null){
            instance = new WalletManager();
        }
        return instance;
    }

    /**
     * Adds a specified amount of credits to the balance
     * @param credit amount to be added
     */
    public void addCredit(int credit){
        this.balance += credit;
    }

    /**
     * Deducts a specified amount of credits from the balance
     * @param credit amount to be deducted
     */
    public void removeCredit(int credit) { this.balance -= credit; }

    /**
     * Returns the current balance
     * @return the current balance
     */
    public int getBalance(){
        return balance;
    }
}
