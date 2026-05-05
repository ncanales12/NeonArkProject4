package org.example.neonark.data;

import org.example.neonark.model.Warden;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvWardenRepository {

    // Reads all wardens from CSV file
    public List<Warden> getAllWardens() {
        List<Warden> wardens = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/resources/wardens.csv"));

            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {

                // skip header row
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                // split CSV safely (keeps empty values)
                String[] parts = line.split(",", -1);

                // basic safety check
                if (parts.length < 10) {
                    System.out.println("Skipping invalid row in CSV.");
                    continue;
                }

                Warden warden = new Warden(
                        Integer.parseInt(parts[0]),
                        parts[1],
                        parts[2],
                        parts[3],
                        parts[4],
                        parts[5],
                        parts[6],
                        parts[7],
                        parts[8],
                        parts[9],
                        parts.length > 10 ? parts[10] : ""
                );

                wardens.add(warden);
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Could not load wardens.csv. Make sure it exists in src/resources.");
        }

        return wardens;
    }
}