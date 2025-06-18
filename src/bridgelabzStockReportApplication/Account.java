package bridgelabzStockReportApplication;

public class Account {
    private double balance;

    public Account(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
            System.out.println("Initial balance invalid. Setting balance to 0.");
        }
    }

    public void debit(double amount) {
        if (amount > balance) {
            System.out.println("Debit amount exceeded account balance.");
        } else if (amount < 0) {
            System.out.println("Invalid debit amount. Must be positive.");
        } else {
            balance -= amount;
            System.out.println("Debited: ₹" + amount + " | New Balance: ₹" + balance);
        }
    }

    public double getBalance() {
        return balance;
    }
}

