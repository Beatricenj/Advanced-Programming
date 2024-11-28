/* Updated Code for DepositTransaction.java
   */

import java.util.Calendar;


public class DepositTransaction extends BaseTransaction {
    public DepositTransaction(double amount, Calendar date, String transactionID) {
        /**
         * Constructor for DepositTransaction.
         * 
         * Pre-condition:
         * - `amount` must be greater than zero.
         * - `date` must not be null.
         * - `transactionID` must not be empty.
         * 
         * Post-condition:
         * - Creates a deposit transaction object.
         */
        super(amount, date, transactionID);
    }

    @Override
    public void apply(BankAccount ba) {
        /**
         * Applies the deposit transaction to the given BankAccount.
         * 
         * Pre-condition:
         * - The BankAccount object must be initialized.
         * 
         * Post-condition:
         * - Increases the account balance by the transaction amount.
         */
        ba.deposit(amount);
    }
}
