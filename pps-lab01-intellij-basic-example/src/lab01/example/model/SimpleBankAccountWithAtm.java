package lab01.example.model;

public class SimpleBankAccountWithAtm implements BankAccount {

    private static final double ATM_FEE = 1.0;

    private AccountHolder accountHolder;
    private double balance;

    public SimpleBankAccountWithAtm(AccountHolder account, double initialBalance) {
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
            if(amount > 0) {
                this.balance = this.balance + amount - ATM_FEE;
            } else {
                throw new IllegalArgumentException("You can't deposit a negative amount of money");
            }
        } else {
            throw new IllegalArgumentException("Wrong ID");
        }
    }

    @Override
    public void withdraw(int userID, double amount) {
        if(userID == this.accountHolder.getId()) {
            if(amount < this.balance && amount > 0) {
                this.balance = this.balance - amount - ATM_FEE;
            } else {
                throw new IllegalArgumentException("You can't withdraw an amount of money bigger than your balance or a negative amount of money");
            }
        } else {
            throw new IllegalArgumentException("Wrong ID");
        }
    }
}
