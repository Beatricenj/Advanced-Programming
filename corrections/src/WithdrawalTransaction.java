import java.util.Calendar;

/**
 * WithdrawalTransaction class.
 * Represents a withdrawal transaction applied to a BankAccount.
 * This transaction decreases the balance of the specified BankAccount.
 * The transaction can also be reversed to restore the original balance.
 *
 * @author [Your Name]
 * @since 2.2.2
 */
public class WithdrawalTransaction extends BaseTransaction {
    private boolean reversed = false; // Tracks whether the transaction has been reversed

    /**
     * Constructor for WithdrawalTransaction.
     * Initializes a new WithdrawalTransaction object with a specific amount, date, and transaction ID.
     *
     * @param amount The transaction amount, must be a positive double value.
     *               This represents the monetary value to withdraw from the BankAccount.
     * @param date The transaction date, must be a non-null Calendar object representing
     *             the date and time of the transaction.
     * @param transactionID A unique identifier for the transaction, must not be null or empty.
     * Preconditions: amount > 0, date != null, transactionID != null && !transactionID.isEmpty().
     * Postconditions: A WithdrawalTransaction object is created with the specified details.
     */
    public WithdrawalTransaction(double amount, Calendar date, String transactionID) {
        super(amount, date, transactionID);
    }

    /**
     * Applies the withdrawal transaction to the specified BankAccount.
     * Decreases the balance of the BankAccount by the transaction amount.
     *
     * @param ba The BankAccount to which the transaction will be applied.
     *           The BankAccount object must not be null.
     * Preconditions: ba != null, ba.getBalance() >= amount.
     * Postconditions: The balance of the BankAccount is reduced by the transaction amount.
     * @throws InsufficientFundsException if the account balance is less than the transaction amount.
     */
    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        if (ba.getBalance() < amount) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }
        ba.withdraw(amount);
    }

    /**
     * Reverses the withdrawal transaction by restoring the transaction amount to the BankAccount.
     *
     * @param ba The BankAccount to which the reversal will be applied.
     *           The BankAccount object must not be null.
     * @return true if the reversal is successful, false if the transaction has already been reversed.
     * Preconditions: ba != null, transaction must not already be reversed.
     * Postconditions: The balance of the BankAccount is increased by the transaction amount,
     *                 and the transaction is marked as reversed.
     */
    public boolean reverse(BankAccount ba) {
        if (!reversed) {
            ba.deposit(amount); // Restore the original amount
            reversed = true; // Mark the transaction as reversed
            return true;
        }
        return false; // Already reversed
    }
}
