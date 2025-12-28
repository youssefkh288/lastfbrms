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

    // UC03: Generate Invoice
    public Invoice generateInvoice(String bookingId) {
        Booking booking = bookingDAO.findById(bookingId);
        if (booking == null) return null;

        // Logic: Find the price of the facility used in the booking
        double price = 0.0;
        for (Facility f : facilityDAO.findAll()) {
            if (f.getName().equalsIgnoreCase(booking.getFacilityName())) {
                price = f.getPrice();
                break;
            }
        }

        return new Invoice(booking.getId(), price, booking.getDate());
    }
}