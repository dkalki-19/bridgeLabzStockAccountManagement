package bridgelabzStockReportApplication;

public class Stock {
    private String name;
    private int numberOfShares;
    private double sharePrice;

    public Stock(String name, int numberOfShares, double sharePrice) {
        this.name = name;
        this.numberOfShares = numberOfShares;
        this.sharePrice = sharePrice;
    }

    public double getStockValue() {
        return numberOfShares * sharePrice;
    }

    @Override
    public String toString() {
        return "Stock: " + name +
               ", Shares: " + numberOfShares +
               ", Price: ₹" + sharePrice +
               ", Value: ₹" + getStockValue();
    }
}

