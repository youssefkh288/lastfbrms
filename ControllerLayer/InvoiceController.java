package ControllerLayer;

import DataLayer.BookingDAO;
import DataLayer.FacilityDAO;
import DomainLayer.Booking;
import DomainLayer.Facility;
import DomainLayer.Invoice;

public class InvoiceController {
    private BookingDAO bookingDAO;
    private FacilityDAO facilityDAO;

    public InvoiceController() {
        this.bookingDAO = new BookingDAO();
        this.facilityDAO = new FacilityDAO();
    }

    public Invoice generateInvoice(String bookingId) {
        // 1. Get Booking Data
        Booking booking = bookingDAO.findById(bookingId);
        if (booking == null) return null;

        // 2. Get Facility Data 
        Facility facility = null;
        for (Facility f : facilityDAO.findAll()) {
        
            if (f.getName().equalsIgnoreCase(booking.getFacilityName())) {
                facility = f;
                break;
            }
        }

        // Handle case where facility might be deleted/renamed
        if (facility == null) {
            facility = new Facility("UNK", booking.getFacilityName(), "Unknown", "Unknown", 0, 0.0, "Inactive", "-", "-", "-");
        }

        // 3. Create Invoice with both objects
        return new Invoice(booking, facility);
    }
}