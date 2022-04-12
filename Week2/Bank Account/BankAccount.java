public class BankAccount {
    private double checking;
    private double savings;
    private static int accountNum = 0;
    private static double totalMoney;

    public BankAccount () {
        checking = 0;
        savings = 0;
        accountNum++;
        totalMoney = 0;
    }

    public double getChecking () {
        return checking;
    }

    public double getSavings () {
        return savings;
    }

    public void deposit (String option, double amount) {
        if (option.equals("Checking")) {
            checking += amount;
            totalMoney += amount;
        } else if (option.equals("Savings")) {
            savings += amount;
            totalMoney += amount;
        }
    }

    public void withdraw (String option, double amount) {
        if (option.equals("Checking") && amount < checking) {
            checking -= amount;
            totalMoney -= amount;
        } else if (option.equals("Savings") && amount < savings) {
            savings -= amount;
            totalMoney -= amount;
        }
    }

    public double getTotalMoney () {
        return totalMoney;
    }
}
