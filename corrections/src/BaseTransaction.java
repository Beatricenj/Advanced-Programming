import java.util.Calendar;

/**
 * BaseTransaction abstract class.
 * Provides a common structure for all financial transactions. This class implements
 * the TransactionInterface and defines the basic attributes and methods for all transactions.
 * Specific transaction behaviors are defined in the subclasses.


 */
public abstract class BaseTransaction implements TransactionInterface {
    protected final double amount;  // The amount for the transaction
    protected final Calendar date;  // The date of the transaction
    protected final String transactionID;  // Unique identifier for the transaction

    /**
     * Constructor for BaseTransaction.
     * Initializes the transaction with a specific amount, date, and transaction ID.
     *
     * @param amount The transaction amount, must be a positive double value.
     *               This represents the monetary value of the transaction.
     * @param date The transaction date, must be a non-null Calendar object
     *             representing the date and time of the transaction.
     * @param transactionID A unique identifier for the transaction, must be a
     *                      non-null and non-empty String.
     * Preconditions: amount > 0, date != null, transactionID != null && !transactionID.isEmpty().
     * Postconditions: A BaseTransaction object is created with the specified details.
     * @throws IllegalArgumentException if the amount is not positive, or if date or transactionID is null or empty.
     */
    public BaseTransaction(double amount, Calendar date, String transactionID) {
        if (amount <= 0 || date == null || transactionID == null || transactionID.isEmpty()) {
            throw new IllegalArgumentException("Invalid transaction details.");
        }
        this.amount = amount;
        this.date = (Calendar) date.clone(); // Defensive copy to maintain immutability
        this.transactionID = transactionID;
    }

    /**
     * Gets the transaction amount.
     * @return The amount of the transaction as a double.
     */
    @Override
    public double getAmount() {
        return amount;
    }

    /**
     * Gets the transaction date.
     * @return A Calendar object representing the date of the transaction.
     *         A defensive copy of the original date is returned.
     */
    @Override
    public Calendar getDate() {
        return (Calendar) date.clone();
    }

    /**
     * Gets the transaction ID.
     * @return A String representing the unique identifier for the transaction.
     */
    @Override
    public String getTransactionID() {
        return transactionID;
    }

    /**
     * Prints the details of the transaction.
     * Includes the transaction ID, amount, and date in the output.
     */
    @Override
    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + transactionID + ", Amount: " + amount + ", Date: " + date.getTime());
    }

    /**
     * Abstract method to apply the transaction to a specified BankAccount.
     * This method must be implemented by subclasses to define specific transaction behavior.
     *
     * @param ba The BankAccount to which the transaction will be applied.
     *           Must be a non-null BankAccount object.
     * Preconditions: ba != null.
     * Postconditions: The state of the BankAccount is updated based on the transaction type.
     * @throws InsufficientFundsException if the transaction cannot be completed due to insufficient funds.
     */
    @Override
    public abstract void apply(BankAccount ba) throws InsufficientFundsException;
}
