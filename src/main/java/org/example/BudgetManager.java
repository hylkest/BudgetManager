package org.example;
import java.util.ArrayList;
import java.util.List;


public class BudgetManager {
    private List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void printTransactions() {
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
}
