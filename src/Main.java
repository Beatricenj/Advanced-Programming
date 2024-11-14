import java.util.Calendar;

public class Main {
    public static void main(String[] args) throws InsufficientFundsException {
        // Step 1: Create a BankAccount object
        BankAccount account = new BankAccount("123456", 1000.00);

        // Step 2: Create a DepositTransaction and apply it to the BankAccount
        BaseTransaction deposit = new DepositTransaction(200.00, Calendar.getInstance(), "TXN123");
        deposit.apply(account);  // Deposit $200
        deposit.printTransactionDetails();  // Print details of the deposit

        // Step 3: Create a WithdrawalTransaction and apply it to the BankAccount
        BaseTransaction withdrawal = new WithdrawalTransaction(300.00, Calendar.getInstance(), "TXN124");

        try {
            withdrawal.apply(account);  // Attempt to withdraw $300
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
        withdrawal.printTransactionDetails();  // Print details of the withdrawal

        // Step 4: Attempt a large withdrawal to trigger InsufficientFundsException
        BaseTransaction largeWithdrawal = new WithdrawalTransaction(1500.00, Calendar.getInstance(), "TXN125");

        try {
            largeWithdrawal.apply(account);  // This should trigger InsufficientFundsException
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
        largeWithdrawal.printTransactionDetails();

        // Step 5: Print the Final Account Balance
        System.out.println("Final Account Balance: " + account.getBalance());
    }
}
