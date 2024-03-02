package lab01.example.model;

public class BankAccountWithATM implements BankAccount {

    private static final double ATM_FEE = 1.0;

    private AccountHolder accountHolder;
    private double balance;

    public BankAccountWithATM(AccountHolder account, double initialBalance) {
        this.accountHolder = account;
        this.balance = initialBalance;
    }

    @Override
    public AccountHolder getHolder() {
        return this.accountHolder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(int userID, double amount) {
        if(userID == this.accountHolder.getId()) {
            this.balance = this.balance + amount - ATM_FEE;
        } else {
            throw new IllegalArgumentException("Wrong ID");
        }
    }

    @Override
    public void withdraw(int userID, double amount) {
        if(userID == this.accountHolder.getId()) {
            this.balance = this.balance - amount - ATM_FEE;
        } else {
            throw new IllegalArgumentException("Wrong ID");
        }
    }
}
