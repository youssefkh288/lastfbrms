package DataLayer;

import DomainLayer.Facility;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FacilityDAO {
    // NOTE: This looks for the file in the project ROOT folder, not inside src
    private final String FILE_NAME = "facilities.csv";

    public void insert(Facility f) {
        File file = new File(FILE_NAME);
        // DEBUG: Print where we are writing
        System.out.println(">> DEBUG: Writing to file at: " + file.getAbsolutePath());

        try (FileWriter fw = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            
            out.println(f.toString());
            out.flush(); // Force write to disk immediately
            
        } catch (IOException e) {
            System.out.println(">> ERROR: Could not write to file! " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Facility> findAll() {
        List<Facility> list = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println(">> DEBUG: facilities.csv not found at: " + file.getAbsolutePath());
            return list;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) { isHeader = false; continue; } // Skip header
                
                String[] data = line.split(",");
                // Expect 10 columns
                if (data.length >= 10) {
                    try {
                        list.add(new Facility(
                            data[0], // id
                            data[1], // name
                            data[2], // type
                            data[3], // location
                            Integer.parseInt(data[4]), // capacity
                            Double.parseDouble(data[5]), // price
                            data[6], // status
                            data[7], // description
                            data[8], // amenities
                            data[9]  // imageURL
                        ));
                    } catch (NumberFormatException e) {
                        System.out.println(">> DEBUG: Skipped corrupt line: " + line);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return list;
    }
}