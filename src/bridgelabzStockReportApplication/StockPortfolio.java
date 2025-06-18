package bridgelabzStockReportApplication;

import java.util.ArrayList;

public class StockPortfolio {
    private ArrayList<Stock> stocks;

    public StockPortfolio() {
        stocks = new ArrayList<>();
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void printReport() {
        double totalValue = 0;
        System.out.println("\n--- Stock Report ---");
        for (Stock stock : stocks) {
            System.out.println(stock);
            totalValue += stock.getStockValue();
        }
        System.out.println("Total Portfolio Value: ₹" + totalValue);
    }
}
