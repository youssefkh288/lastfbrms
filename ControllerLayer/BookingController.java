package ControllerLayer;

import DataLayer.BookingDAO;
import DataLayer.FacilityDAO;
import DomainLayer.Booking;
import DomainLayer.Facility;
import java.util.ArrayList;
import java.util.List;

public class BookingController {
    private BookingDAO bookingDAO;
    private FacilityDAO facilityDAO;

    public BookingController() {
        this.bookingDAO = new BookingDAO();
        this.facilityDAO = new FacilityDAO();
    }

    // UC05: View Availability (Complex Read)
    public List<Facility> getAvailableFacilities(String date, String time) {
        List<Facility> allFacilities = facilityDAO.findAll();
        List<Booking> bookings = bookingDAO.findAll();
        List<Facility> available = new ArrayList<>();

        for (Facility f : allFacilities) {
            boolean isBooked = false;
            for (Booking b : bookings) {
                // Logic: If facility name matches AND date/time matches, it's taken
                if (b.getFacilityName().equalsIgnoreCase(f.getName()) && 
                    b.getDate().equalsIgnoreCase(date) &&
                    b.getTime().equalsIgnoreCase(time)) {
                    isBooked = true;
                    break;
                }
            }
            if (!isBooked) {
                available.add(f);
            }
        }
        return available;
    }
}