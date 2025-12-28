package DataLayer;

import DomainLayer.Booking;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    private final String FILE_NAME = "bookings.csv";

    // Read (Load all bookings)
    public List<Booking> findAll() {
        List<Booking> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 5) {
                    list.add(new Booking(data[0], data[1], data[2], data[3], data[4]));
                }
            }
        } catch (IOException e) {
            // File might not exist yet
        }
        return list;
    }

    // Read (Find specific booking by ID)
    public Booking findById(String id) {
        for (Booking b : findAll()) {
            if (b.getId().equalsIgnoreCase(id)) return b;
        }
        return null;
    }
}