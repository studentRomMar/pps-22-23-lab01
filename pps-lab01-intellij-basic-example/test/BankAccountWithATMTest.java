import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.BankAccountWithATM;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountWithATMTest {

    private static final double TEST_AMOUNT_OF_MONEY = 100.0;
    private static final double ATM_FEE = 1.0;

    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach() {
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new BankAccountWithATM(accountHolder, 0.0);
    }

    @Test
    void createSuccessfullyBankAccount() {
        assertEquals(0.0, this.bankAccount.getBalance());
    }

    @Disabled
    void getHolderTest() {
        assertEquals("[ID = 1] Mario Rossi", this.bankAccount.getHolder());
    }

    @Test
    void depositWithATMTest() {
        this.bankAccount.deposit(this.accountHolder.getId(), TEST_AMOUNT_OF_MONEY);
        assertEquals(TEST_AMOUNT_OF_MONEY - ATM_FEE, this.bankAccount.getBalance());
    }

    @Test
    void withdrawWithATMTest() {
        this.bankAccount.deposit(this.accountHolder.getId(), 2 * TEST_AMOUNT_OF_MONEY);
        this.bankAccount.withdraw(this.accountHolder.getId(), TEST_AMOUNT_OF_MONEY);
        double expectedValue = 2 * TEST_AMOUNT_OF_MONEY - TEST_AMOUNT_OF_MONEY - 2 * ATM_FEE;
        assertEquals(expectedValue, this.bankAccount.getBalance());
    }

    @Test
    void depositWrongIdTest() {
        assertThrows(IllegalArgumentException.class, () -> this.bankAccount.deposit(2, TEST_AMOUNT_OF_MONEY));
    }

    @Test
    void cannotDepositNegativeAmountTest() {
        assertThrows(IllegalArgumentException.class,
                () -> this.bankAccount.deposit(this.accountHolder.getId(), -TEST_AMOUNT_OF_MONEY));
    }

    @Test
    void withdrawWrongIdTest() {
        this.bankAccount.deposit(this.accountHolder.getId(), 2*TEST_AMOUNT_OF_MONEY);
        assertThrows(IllegalArgumentException.class, () -> this.bankAccount.withdraw(2, TEST_AMOUNT_OF_MONEY));
    }

    @Test
    void cannotWithdrawBiggerThanBalanceTest() {
        this.bankAccount.deposit(this.accountHolder.getId(), TEST_AMOUNT_OF_MONEY);
        assertThrows(IllegalArgumentException.class,
                () -> this.bankAccount.withdraw(this.accountHolder.getId(), 2*TEST_AMOUNT_OF_MONEY));
    }

    @Test
    void cannotWithdrawNegativeAmount() {
        this.bankAccount.deposit(this.accountHolder.getId(), TEST_AMOUNT_OF_MONEY);
        assertThrows(IllegalArgumentException.class,
                () -> this.bankAccount.withdraw(this.accountHolder.getId(), -TEST_AMOUNT_OF_MONEY));
    }
}
