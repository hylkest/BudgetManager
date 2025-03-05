package org.example;
import java.util.ArrayList;
import java.util.List;


public class BudgetManager {
    private List<Transaction> transactions = new ArrayList<>();
    private double budgetLimit = Double.MAX_VALUE;

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);

        if (calculateBalance() > budgetLimit) {
            System.out.println("Over het budget heen.");
        }
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

    public void removeTransaction(String description, double amount) {
        for (Transaction t : transactions) {
            if (t.getDescription().equals(description) && t.getAmount() == amount) {
                transactions.remove(t);
            } else {
                System.out.println("Transactie does not exist");
            }
        }
    }

    public void setBudgetLimit(double limit) {
        this.budgetLimit = limit;
    }
}
