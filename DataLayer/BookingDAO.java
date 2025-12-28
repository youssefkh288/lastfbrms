package DataLayer;

import DomainLayer.Booking;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    private final String FILE_NAME = "bookings.csv";

    public List<Booking> findAll() {
        List<Booking> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                if (isHeader) { isHeader = false; continue; }
                
                String[] data = line.split(",");
                
                
                if (data.length >= 11) {
                    list.add(new Booking(
                        data[0], // id
                        data[1], // facilityName
                        data[2], // memberName
                        data[3], // status
                        data[4], // date
                        data[5], // time
                        data[6], // email
                        data[7], // phone
                        data[8], // bookedOn
                        data[9], // paymentMethod
                        Double.parseDouble(data[10]) // serviceFee
                    ));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading bookings: " + e.getMessage());
        }
        return list;
    }

    public Booking findById(String id) {
        for (Booking b : findAll()) {
            if (b.getId().equalsIgnoreCase(id)) return b;
        }
        return null;
    }
}