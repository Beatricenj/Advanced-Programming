/* Updated Code for WithdrawalTransaction.java

  */




import java.util.Calendar;

/**
 * Represents a withdrawal transaction.
 * 
 * Specifications:
 * - Requires:
 *   - A valid BankAccount object with sufficient funds.
 * - Produces:
 *   - Deducts funds from the account or allows partial withdrawal.
 */
public class WithdrawalTransaction extends BaseTransaction {
    private boolean reversed;  // Tracks if the transaction has already been reversed

    public WithdrawalTransaction(double amount, Calendar date, String transactionID) {
        /**
         * Constructor for WithdrawalTransaction.
         * 
         * Pre-condition:
         * - `amount` must be greater than zero.
         * - `date` must not be null.
         * - `transactionID` must not be empty.
         * 
         * Post-condition:
         * - Creates a withdrawal transaction object.
         */
        super(amount, date, transactionID);
        this.reversed = false;
    }

    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        /**
         * Applies the withdrawal transaction to the given BankAccount.
         * 
         * Pre-condition:
         * - The account must have sufficient funds to cover the withdrawal amount.
         * 
         * Post-condition:
         * - Deducts the transaction amount from the account balance.
         * 
         * Throws:
         * - InsufficientFundsException if funds are insufficient.
         */
        if (ba.getBalance() < amount) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }
        ba.withdraw(amount);
        this.reversed = false;
    }

    public void apply(BankAccount ba, boolean allowPartialWithdrawal) {
        /**
         * Applies a withdrawal transaction, allowing partial withdrawal if enabled.
         * 
         * Pre-condition:
         * - `ba` must be a valid BankAccount object.
         * - Partial withdrawal is allowed, and balance is greater than zero.
         * 
         * Post-condition:
         * - Withdraws the entire amount if sufficient funds are available.
         * - Withdraws the available balance if partial withdrawal is allowed.
         * - Outputs the shortfall if applicable.
         * 
         * Throws:
         * - InsufficientFundsException if no funds are available and partial withdrawal is not allowed.
         */
        try {
            if (ba.getBalance() >= amount) {
                ba.withdraw(amount);
                System.out.println("Full withdrawal successful.");
            } else if (allowPartialWithdrawal && ba.getBalance() > 0) {
                double available = ba.getBalance();
                ba.withdraw(available);
                double shortfall = amount - available;
                System.out.println("Partial withdrawal: Only " + available + " was available. Shortfall of " + shortfall);
            } else {
                throw new InsufficientFundsException("Insufficient funds for withdrawal.");
            }
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public boolean reverse(BankAccount ba) {
        /**
         * Reverses the withdrawal transaction.
         * 
         * Pre-condition:
         * - The transaction must not have been reversed previously.
         * 
         * Post-condition:
         * - Restores the transaction amount to the account balance.
         * - Marks the transaction as reversed.
         * 
         * Returns:
         * - true if reversal was successful, false otherwise.
         */
        if (!reversed) {
            ba.deposit(amount);
            reversed = true;
            System.out.println("Transaction reversed successfully.");
            return true;
        } else {
            System.out.println("Transaction has already been reversed.");
            return false;
        }
    }
}
