package bridgelabzCommercialDataProcessing;

import java.util.Scanner;

public class StockAccountApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StockAccount account = new StockAccount("portfolio.txt");

        while (true) {
            System.out.println("\n1. Buy\n2. Sell\n3. Print Report\n4. Save\n5. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter stock symbol to buy: ");
                    String buySymbol = scanner.next();
                    System.out.print("Enter number of shares to buy: ");
                    int buyAmount = scanner.nextInt();
                    account.buy(buyAmount, buySymbol);
                    break;

                case 2:
                    System.out.print("Enter stock symbol to sell: ");
                    String sellSymbol = scanner.next();
                    System.out.print("Enter number of shares to sell: ");
                    int sellAmount = scanner.nextInt();
                    account.sell(sellAmount, sellSymbol);
                    break;

                case 3:
                    account.printReport();
                    break;

                case 4:
                    account.save("portfolio.txt");
                    break;

                case 5:
                    System.out.println("Exiting.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

