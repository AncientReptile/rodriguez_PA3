public class TestClass
{
    public static void main(String[] args)
    {
        // Creates two accounts
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);

        // Calculates the monthly interest based off accounts for .04
        SavingsAccount.modifyInterestRate(0.04);
        for(int i = 0; i < 12; i++)
        {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
        }
        System.out.println("Saver 1 at 4%: " + saver1.currentBalance());
        System.out.println("Saver 2 at 4%: " + saver2.currentBalance());

        // Calculates the monthly interest based off accounts for .05
        SavingsAccount.modifyInterestRate(0.05);
        for(int i = 0; i < 12; i++)
        {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
        }
        System.out.println("Saver 1 at 5%: " + saver1.currentBalance());
        System.out.println("Saver 2 at 5%: " + saver2.currentBalance());
    }
}
