package savingsaccount;

public class SavingsAccount {
    public static double annualInterestRate = 0.06;
    private double savingsBalance;
    SavingsAccount(double num) {
        savingsBalance = num;
    }
    double calculateMonthlyInterest() {
        double interest = savingsBalance * annualInterestRate / 12.0;
        savingsBalance += interest;
        return interest;
    }
    void modifyInterestRate(double newInterest) {
        annualInterestRate = newInterest;
    }
}