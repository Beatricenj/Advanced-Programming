import java.util.Calendar;

/**
 * DepositTransaction class.
 * Represents a deposit transaction on a BankAccount. This transaction increases the balance
 * of the specified BankAccount by the transaction amount.
 *
 * @author [Your Name]
 * @since 2.2.2
 */
public class DepositTransaction extends BaseTransaction {

    /**
     * Constructor for DepositTransaction.
     * Initializes a new DepositTransaction object with the specified amount, date, and transaction ID.
     *
     * @param amount The transaction amount, must be a positive double value.
     *               This value will be added to the BankAccount's balance when applied.
     * @param date The transaction date, must be a non-null Calendar object representing
     *             the date and time of the transaction.
     * @param transactionID A unique identifier for the transaction, must be a non-null and non-empty String.
     * Preconditions: amount > 0, date != null, transactionID != null && !transactionID.isEmpty().
     * Postconditions: A DepositTransaction object is created with the specified details.
     */
    public DepositTransaction(double amount, Calendar date, String transactionID) {
        super(amount, date, transactionID);
    }

    /**
     * Applies the deposit transaction to the specified BankAccount.
     * Increases the balance of the BankAccount by the transaction amount.
     *
     * @param ba The BankAccount to which the transaction will be applied.
     *           The BankAccount object must not be null.
     * Preconditions: ba != null.
     * Postconditions: The balance of the BankAccount is increased by the transaction amount.
     */
    @Override
    public void apply(BankAccount ba) {
        ba.deposit(amount);
    }
}
