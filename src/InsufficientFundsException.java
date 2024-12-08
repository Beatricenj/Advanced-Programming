/**
 * InsufficientFundsException class.
 * This exception is thrown when a withdrawal operation is attempted on a BankAccount
 * with insufficient funds to complete the transaction.
 */
public class InsufficientFundsException extends Exception {

    /**
     * Constructs a new InsufficientFundsException with the specified detail message.
     * @param message A detailed error message that provides context about why the exception was thrown.
     *                The message must not be null or empty.
     * Preconditions: message != null && !message.isEmpty().
     * Postconditions: An InsufficientFundsException object is created with the specified message.
     */
    public InsufficientFundsException(String message) {
        super(message);
    }
}
