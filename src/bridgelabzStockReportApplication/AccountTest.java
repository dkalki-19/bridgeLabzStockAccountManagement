package bridgelabzStockReportApplication;

public class AccountTest {
    public static void main(String[] args) {
        System.out.println("Creating account with ₹1000...");
        Account myAccount = new Account(1000);

        System.out.println("\nAttempting to debit ₹300:");
        myAccount.debit(300);  // Expected: Success, new balance ₹700

        System.out.println("\nAttempting to debit ₹800:");
        myAccount.debit(800);  // Expected: Failure, balance unchanged

        System.out.println("\nAttempting to debit ₹-50:");
        myAccount.debit(-50);  // Expected: Invalid input

        System.out.println("\nFinal Balance: ₹" + myAccount.getBalance());
    }
}

