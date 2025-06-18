package bridgelabzCommercialDataProcessing;

import java.util.*;
import java.io.*;

public class StockAccount {
    private final List<CompanyShares> portfolio;

    public StockAccount(String filename) {
        portfolio = new ArrayList<>();
        load(filename);
    }

    public double valueOf() {
        double total = 0;
        for (CompanyShares cs : portfolio) {
            // Dummy share price = 100 for each, or fetch real-time later
            total += cs.getShares() * 100;
        }
        return total;
    }

    public void buy(int amount, String symbol) {
        for (CompanyShares cs : portfolio) {
            if (cs.getSymbol().equalsIgnoreCase(symbol)) {
                cs.addShares(amount);
                return;
            }
        }
        portfolio.add(new CompanyShares(symbol, amount));
    }

    public void sell(int amount, String symbol) {
        for (CompanyShares cs : portfolio) {
            if (cs.getSymbol().equalsIgnoreCase(symbol)) {
                if (cs.getShares() >= amount) {
                    cs.removeShares(amount);
                    return;
                } else {
                    System.out.println("Not enough shares to sell!");
                    return;
                }
            }
        }
        System.out.println("Stock not found!");
    }

    public void save(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (CompanyShares cs : portfolio) {
                writer.println(cs.getSymbol() + "," + cs.getShares());
            }
            System.out.println("Portfolio saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void load(String filename) {
        File file = new File(filename);
        if (!file.exists()) return;

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                if (data.length == 2) {
                    String symbol = data[0].trim();
                    int shares = Integer.parseInt(data[1].trim());
                    portfolio.add(new CompanyShares(symbol, shares));
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file.");
        }
    }

    public void printReport() {
        System.out.println("\n--- Stock Account Report ---");
        for (CompanyShares cs : portfolio) {
            System.out.println(cs);
        }
        System.out.println("Total Value: ₹" + valueOf());
    }
}
