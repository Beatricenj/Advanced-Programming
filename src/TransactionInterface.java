import java.util.Calendar;

public interface TransactionInterface {
    /**
     * Get the transaction amount.
     * @return Transaction amount as double.
     */
    double getAmount();

    /**
     * Get the transaction date.
     * @return Calendar object representing the transaction date.
     */
    Calendar getDate();

    /**
     * Get the transaction ID.
     * @return Unique transaction ID as String.
     */
    String getTransactionID();

    /**
     * Print the transaction details.
     */
    void printTransactionDetails();

    /**
     * Apply the transaction to the given bank account.
     * @param ba The BankAccount to apply the transaction to.
     * @throws InsufficientFundsException if there are insufficient funds for the transaction.
     */
    void apply(BankAccount ba) throws InsufficientFundsException;
}
