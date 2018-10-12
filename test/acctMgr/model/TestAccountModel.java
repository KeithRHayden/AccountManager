package acctMgr.model;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;
import java.math.BigInteger;

public class TestAccountModel {

    @Test
    public void testDeposit() {
        AccountModel model = new AccountModel(BigInteger.valueOf(1L), "keith", BigDecimal.valueOf(79_000_000f));
        model.deposit(BigDecimal.valueOf(1f));
        Assertions.assertEquals(model.getBalance(), BigDecimal.valueOf(79_000_001f));
    }

    @Test
    public void testWithdraw() throws OverdraftException {
        AccountModel model = new AccountModel(BigInteger.valueOf(1L), "keith", BigDecimal.valueOf(79_000_000f));
        model.withdraw(BigDecimal.valueOf(1f));
        Assertions.assertEquals(model.getBalance(), BigDecimal.valueOf(78_999_999f));
    }

    @Test
    public void testToString() {
        AccountModel model = new AccountModel(BigInteger.valueOf(1L), "keith", BigDecimal.valueOf(79_000_000f));
        Assertions.assertEquals(model.toString(), "1,keith,79000000.00");
    }

    @Test
    public void testOverdraftException() {
        AccountModel model = new AccountModel(BigInteger.valueOf(1L), "keith", BigDecimal.valueOf(0f));
        Assertions.assertThrows(OverdraftException.class, () -> { model.withdraw(BigDecimal.valueOf(5f)); });
    }
}
