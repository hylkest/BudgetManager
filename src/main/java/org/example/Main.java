package org.example;
import java.io.*;
import java.util.Random;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        File data = new File("data.csv");
        if (data.exists()) {
            System.out.println("Bestand bestaat al");
            String searchName = "Naam132932";

            boolean foundName = readData(searchName);
            ArrayList<String> names = new ArrayList<String>();


            if (foundName) {
                System.out.println("Found name: " + searchName);
                names.add(searchName);
            } else {
                System.out.println("Name not found");
            }

            for (String name : names) {
                System.out.println(name);
            }

        } else {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(data));
                Random random = new Random();

                for (int i = 1; i <= 1_000_000; i++) {
                    String naam = "Naam" + random.nextInt(1000000); // Willekeurige naam
                    writer.write(i + "," + naam);
                    writer.newLine();
                }

                writer.close();
                System.out.println("Data is succesvol gegenereerd en opgeslagen.");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean readData(String searchName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data.csv"));
            String lijn;
            while ((lijn = reader.readLine()) != null) {
                String[] delen = lijn.split(",");
                String naam = delen[1];
                if (naam.equals(searchName)) {
                    reader.close();
                    return true;
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
