package game.managers;

import game.terrain.Wall;

public class WalletManager {
    private static WalletManager instance;
    private int balance;

    private WalletManager(){}

    public static WalletManager getInstance(){
        if (instance == null){
            instance = new WalletManager();
        }
        return instance;
    }

    public void addCredit(int credit){
        this.balance += credit;
    }

    public void removeCredit(int credit) { this.balance -= credit; }

    public int getBalance(){
        return balance;
    }
}
