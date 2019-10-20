public class SavingsAccount
{
    static double annualInterestRate;
    private double savingsBalance;

    // Initializes the savings account with the starting balance
    public SavingsAccount(double startingBalance)
    {
        savingsBalance = startingBalance;
    }

    // Calculates the savings balance after a single month passes
    public void calculateMonthlyInterest()
    {
        savingsBalance = savingsBalance + savingsBalance * (annualInterestRate / 12);
    }

    // Modifies the interest rate for the saving accounts
    public static void modifyInterestRate(double newRate)
    {
        annualInterestRate = newRate;
    }

    // Provides the current balance for the account
    public double currentBalance()
    {
        return savingsBalance;
    }

}
