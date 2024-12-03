import java.util.Calendar;

public abstract class BaseTransaction implements TransactionInterface {
    protected final double amount;
    protected final Calendar date;
    protected final String transactionID;

    /**
     * BaseTransaction constructor.
     * @param amount The transaction amount, must be positive.
     * @param date The transaction date, cannot be null.
     * @param transactionID The unique transaction ID, cannot be null or empty.
     */
    public BaseTransaction(double amount, Calendar date, String transactionID) {
        if (amount <= 0 || date == null || transactionID == null || transactionID.isEmpty()) {
            throw new IllegalArgumentException("Invalid transaction details.");
        }
        this.amount = amount;
        this.date = (Calendar) date.clone(); // Defensive copy
        this.transactionID = transactionID;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public Calendar getDate() {
        return (Calendar) date.clone(); // Defensive copy
    }

    @Override
    public String getTransactionID() {
        return transactionID;
    }

    @Override
    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + transactionID + ", Amount: " + amount + ", Date: " + date.getTime());
    }

    @Override
    public abstract void apply(BankAccount ba) throws InsufficientFundsException;
}
