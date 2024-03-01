import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.BankAccountWithATM;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountWithATMTest {

    private static final double TEST_AMOUNT_OF_MONEY = 100.0;
    private static final int ID_TEST = 1;

    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach() {
        accountHolder = new AccountHolder("Mario", "Rossi", ID_TEST);
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
        this.bankAccount.deposit(ID_TEST, TEST_AMOUNT_OF_MONEY);
        assertEquals(99.0, this.bankAccount.getBalance());
    }

    @Test
    void withdrawWithATMTest() {
        this.bankAccount.deposit(ID_TEST, 2 * TEST_AMOUNT_OF_MONEY);
        this.bankAccount.withdraw(ID_TEST, TEST_AMOUNT_OF_MONEY);
        double expectedValue = 2 * TEST_AMOUNT_OF_MONEY - TEST_AMOUNT_OF_MONEY - 2;
        assertEquals(expectedValue, this.bankAccount.getBalance());
    }
}
