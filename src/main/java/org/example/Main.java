package org.example;

public class Main {

    public static void main(String[] args) {
        Transaction tr1 = new Transaction("Boodschappen", 10, "Lifestyle");
        Transaction tr2 = new Transaction("Test123", 10, "Overig");
        BudgetManager manager = new BudgetManager();

        manager.addTransaction(tr1);
        manager.addTransaction(tr2);
        manager.saveTransactions();
        manager.loadTransactions();

    }
}
