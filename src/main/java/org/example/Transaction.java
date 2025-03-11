package org.example;

import java.time.LocalDate;
import java.util.Random;

public class Transaction {
    private LocalDate date;
    private String description;
    private double amount;
    private int id;
    private String category;


    public Transaction(String description, double amount, String category) {
        Random rand = new Random();

        this.date = LocalDate.now();
        this.id = rand.nextInt(99999999);
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return date + " | " + category + " | " + amount + " | " + description;
    }
}
