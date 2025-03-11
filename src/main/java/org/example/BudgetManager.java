package org.example;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class BudgetManager {
    private List<Transaction> transactions = new ArrayList<>();
    private double budgetLimit = Double.MAX_VALUE;

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);

        if (calculateBalance() > budgetLimit) {
            System.out.println("Exceeded budget limit");
        }
    }

    public void printTransactions() {
        transactions.sort(Comparator.comparing(Transaction::getAmount).reversed());

        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    public double calculateBalance() {
        double balance = 0;
        for (Transaction t : transactions) {
            balance += t.getAmount();
        }
        return balance;
    }

    public void printTransactionsByCategory(String category) {
        for (Transaction t : transactions) {
            if (t.getCategory().equals(category)) {
                System.out.println(t);
            } else {
                System.out.println("No category found");
            }
        }
    }

    public void removeTransaction(String description, double amount) {
        for (Transaction t : transactions) {
            if (t.getDescription().equals(description) && t.getAmount() == amount) {
                transactions.remove(t);
            } else {
                System.out.println("Transaction does not exist");
            }
        }
    }

    public void setBudgetLimit(double limit) {
        this.budgetLimit = limit;
    }

    public void saveTransactions() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.txt"))) {
            for (Transaction t : transactions) {
                writer.write(t.getId() + " | " + t.getDate() + " | " + t.getCategory() + " | " + t.getAmount() + " | " + t.getDescription());
                writer.newLine();
            }
            System.out.println("Saved transactions");
        } catch (IOException e) {
            System.err.println("Error saving transactions: " + e.getMessage());
        }
    }

    public void loadTransactions() {
        try (BufferedReader reader = new BufferedReader(new FileReader("transactions.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" \\| ");

                if (parts.length == 4) {
                    LocalDate date = LocalDate.parse(parts[0].trim());
                    String category = parts[1].trim();
                    double amount = Double.parseDouble(parts[2].trim());
                    String description = parts[3].trim();

                    Transaction transaction = new Transaction(description, amount, category);
                    transactions.add(transaction);
                } else {
                    System.out.println("Error in txt file");
                }
                System.out.println("Loaded transactions");
            }
        } catch (IOException e) {
            System.err.println("Error loading transactions: " + e.getMessage());
        }
    }
}
