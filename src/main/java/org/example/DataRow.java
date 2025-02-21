package org.example;

public class DataRow {
    private int id;
    private String naam;

    public DataRow(int id, String naam) {
            this.id = id;
            this.naam = naam;
    }

    // Geeft alleen id terug
    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }
}
