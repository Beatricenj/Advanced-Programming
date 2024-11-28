
/*Specifications for ADTs

Issue #2: Incomplete Specification

Updated Code for BaseTransaction.java
*/


import java.util.Calendar;

/**
 * Abstract BaseTransaction class providing a blueprint for financial transactions.
 * 
 * Specifications:
 * - Requires: A valid BankAccount object.
 * - Produces: Updates the account balance based on transaction type.
 */
public abstract class BaseTransaction implements TransactionInterface {
    protected double amount;
    protected Calendar date;
    protected String transactionID;

    /**
     * Constructor for BaseTransaction.
     * 
     * Pre-condition:
     * - `amount` must be greater than zero.
     * - `date` must not be null.
     * - `transactionID` must not be empty.
     * 
     * Post-condition:
     * - Creates a transaction object with the specified attributes.
     */
    public BaseTransaction(double amount, Calendar date, String transactionID) {
        this.amount = amount;
        this.date = date;
        this.transactionID = transactionID;
    }

    @Override
    public double getAmount() {
        /**
         * Returns the transaction amount.
         * 
         * Pre-condition:
         * - The transaction object must be initialized.
         * 
         * Post-condition:
         * - Returns a positive double representing the transaction amount.
         */
        return amount;
    }

    @Override
    public Calendar getDate() {
        /**
         * Returns the transaction date.
         * 
         * Pre-condition:
         * - The transaction object must be initialized.
         * 
         * Post-condition:
         * - Returns a valid Calendar object representing the date.
         */
        return date;
    }

    @Override
    public String getTransactionID() {
        /**
         * Returns the unique transaction ID.
         * 
         * Pre-condition:
         * - The transaction object must be initialized.
         * 
         * Post-condition:
         * - Returns a non-empty string representing the transaction ID.
         */
        return transactionID;
    }

    @Override
    public void printTransactionDetails() {
        /**
         * Prints the transaction details.
         * 
         * Pre-condition:
         * - The transaction object must be initialized.
         * 
         * Post-condition:
         * - Outputs the transaction details to the console.
         */
        System.out.println("Transaction ID: " + transactionID + ", Amount: " + amount + ", Date: " + date.getTime());
    }

    @Override
    public abstract void apply(BankAccount ba) throws InsufficientFundsException;
}
