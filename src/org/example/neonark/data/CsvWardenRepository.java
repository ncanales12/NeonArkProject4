package org.example.neonark.data;

import org.example.neonark.model.Warden;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvWardenRepository {

    public List<Warden> getAllWardens() {
        List<Warden> wardens = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/resources/wardens.csv"));

            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] parts = line.split(",", -1);

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
                        parts[10]
                );

                wardens.add(warden);
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error reading CSV file. Make sure wardens.csv is in src/resources.");
        }

        return wardens;
    }
}