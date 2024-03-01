package lab01.example.model;

public class BankAccountWithATM implements BankAccount {

    private AccountHolder accountHolder;
    private double balance;

    public BankAccountWithATM(AccountHolder account, double initialBalance) {
        this.accountHolder = account;
        this.balance = initialBalance;
    }

    @Override
    public AccountHolder getHolder() {
        return null;
    }

    @Override
    public double getBalance() {
        return 0;
    }

    @Override
    public void deposit(int userID, double amount) {

    }

    @Override
    public void withdraw(int userID, double amount) {

    }
}
