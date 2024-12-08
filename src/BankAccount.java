/**
 * BankAccount class.
 * Represents a simple bank account that supports deposits and withdrawals, and tracks the account balance.
 * Includes basic validation for transactions and provides access to account details.
 *
 * @author [Your Name]
 * @since 2.2.2
 */
public class BankAccount {
    private final String accountNumber; // The unique account number of the bank account
    private double balance; // The current balance of the bank account

    /**
     * Constructor for BankAccount.
     * Initializes a new BankAccount object with a unique account number and an initial balance.
     *
     * @param accountNumber The unique account number, must not be null or empty.
     * @param initialBalance The initial balance of the account, must be a non-negative double value.
     * Preconditions: accountNumber != null && !accountNumber.isEmpty(), initialBalance >= 0.
     * Postconditions: A BankAccount object is created with the specified account number and balance.
     * @throws IllegalArgumentException if accountNumber is null or empty, or if initialBalance is negative.
     */
    public BankAccount(String accountNumber, double initialBalance) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be null or empty.");
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    /**
     * Gets the account number.
     * @return The account number as a String.
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Gets the current balance of the account.
     * @return The current balance as a double value.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Deposits the specified amount into the account.
     * @param amount The amount to deposit, must be a positive double value.
     * Preconditions: amount > 0.
     * Postconditions: The account balance is increased by the specified amount.
     * @throws IllegalArgumentException if the amount is not positive.
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
    }

    /**
     * Withdraws the specified amount from the account.
     * @param amount The amount to withdraw, must be a positive double value.
     * Preconditions: amount > 0.
     * Postconditions: The account balance is reduced by the specified amount.
     * @throws IllegalArgumentException if the amount is not positive.
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        balance -= amount;
    }
}
