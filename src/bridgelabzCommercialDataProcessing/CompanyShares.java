package bridgelabzCommercialDataProcessing;

import java.time.LocalDateTime;

public class CompanyShares {
    private String symbol;
    private int shares;
    private LocalDateTime dateTime;

    public CompanyShares(String symbol, int shares) {
        this.symbol = symbol;
        this.shares = shares;
        this.dateTime = LocalDateTime.now();
    }

    public String getSymbol() {
        return symbol;
    }

    public int getShares() {
        return shares;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void addShares(int amount) {
        this.shares += amount;
        this.dateTime = LocalDateTime.now();
    }

    public void removeShares(int amount) {
        this.shares -= amount;
        this.dateTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return symbol + " - Shares: " + shares + " | Last Transaction: " + dateTime;
    }
}

