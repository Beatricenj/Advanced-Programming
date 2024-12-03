import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {
    private boolean reversed = false; // Tracks whether the transaction has been reversed

    public WithdrawalTransaction(double amount, Calendar date, String transactionID) {
        super(amount, date, transactionID);
    }

    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        if (ba.getBalance() < amount) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }
        ba.withdraw(amount);
    }

    public boolean reverse(BankAccount ba) {
        if (!reversed) {
            ba.deposit(amount); // Restore the original amount
            reversed = true;
            return true;
        }
        return false; // Already reversed
    }
}
