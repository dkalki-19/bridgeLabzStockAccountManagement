package bridgelabzStockReportApplication;

import java.util.Scanner;

public class StockReportApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StockPortfolio portfolio = new StockPortfolio();

        System.out.println("Enter the number of stocks:");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter stock name for stock " + i + ":");
            String name = scanner.next();

            System.out.println("Enter number of shares:");
            int shares = scanner.nextInt();

            System.out.println("Enter share price:");
            double price = scanner.nextDouble();

            portfolio.addStock(new Stock(name, shares, price));
        }

        portfolio.printReport();
        scanner.close();
    }
}
