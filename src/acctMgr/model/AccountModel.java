package acctMgr.model;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * A single user account containing their balance and personal details.
 */
public class AccountModel extends CalculatorModel {

    private BigDecimal balance;
    private String name;
    private BigInteger id;

    public AccountModel(BigInteger id, String name, BigDecimal balance) {
        this.balance = balance;
        this.name = name;
        this.id = id;
    }

    /**
     * Read a comma delimited line containing the account id, name, and balance
     *
     * @param line CSV line of account info.
     * @return An instance of an account model with the data from the csv line.
     */
    public static AccountModel fromLine (String line) {
        String[] lineParts = line.split(",");
        // Parse id
        BigInteger id = BigInteger.valueOf(Long.valueOf(lineParts[0]));
        // Parse name
        String name = lineParts[1];
        // Parse balance
        BigDecimal balance = BigDecimal.valueOf(Float.valueOf(lineParts[2]));
        return new AccountModel(id, name, balance);
    }

    /**
     * Add an amount to the account's balance.
     *
     * @param amount The amount to deposit.
     */
    public void deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    /**
     * Withdraw an amount from the account's balance.
     *
     * @param amount The amount to withdraw.
     * @throws OverdraftException
     */
    public void withdraw(BigDecimal amount) throws OverdraftException {
        BigDecimal newBalance = this.balance.subtract(amount);
        if (newBalance.compareTo(new BigDecimal(0L)) < 0) {
            throw new OverdraftException("Not enough money");
        }
    }

    public BigDecimal getBalance () {
        return this.balance;
    }

    public String getName () {
        return this.name;
    }

    public BigInteger getId () {
        return this.id;
    }

    @Override
    public String toString() {
        return String.format("%d,%s,%f", this.getId(), this.getName(), this.getBalance());
    }
}
