package org.example;

public class Auto {
    // Variabelen aanmaken
    private String merk;
    private String model;
    private int snelheid;

    public Auto(String merk, String model) {
        this.merk = merk;
        this.model = model;
        this.snelheid = 0;
    }

    public void versnellen(int verhoging) {
        snelheid += verhoging;
        System.out.println("Snelheid verhoogt naar: " + snelheid);
    }

    public void afremmen(int vermindering) {
        snelheid -= vermindering;
        if (snelheid < 0) snelheid = 0;
        System.out.println("Snelheid is nu: " + snelheid);
    }
}