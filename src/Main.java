import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        try {
            // Step 1: Create a BankAccount object
            BankAccount account = new BankAccount("123456", 1000.00);

            // Step 2: Create and apply a DepositTransaction
            BaseTransaction deposit = new DepositTransaction(200.00, Calendar.getInstance(), "TXN123");
            deposit.apply(account);
            deposit.printTransactionDetails();

            // Step 3: Create and apply a WithdrawalTransaction
            WithdrawalTransaction withdrawal = new WithdrawalTransaction(300.00, Calendar.getInstance(), "TXN124");
            withdrawal.apply(account);
            withdrawal.printTransactionDetails();

            // Step 4: Reverse the WithdrawalTransaction
            boolean reversed = withdrawal.reverse(account);
            System.out.println("Reversed: " + reversed);

            // Step 5: Attempt a large withdrawal to trigger InsufficientFundsException
            BaseTransaction largeWithdrawal = new WithdrawalTransaction(1500.00, Calendar.getInstance(), "TXN125");
            try {
                largeWithdrawal.apply(account);
            } catch (InsufficientFundsException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // Step 6: Print the final account balance
            System.out.println("Final Account Balance: " + account.getBalance());

        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }
}