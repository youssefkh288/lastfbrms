package DomainLayer;

public class Invoice {
    private Booking booking;
    private Facility facility; 

    public Invoice(Booking booking, Facility facility) {
        this.booking = booking;
        this.facility = facility;
    }

    public String printInvoice() {
        double facilityFee = facility.getPrice();
        double total = facilityFee + booking.getServiceFee();

        StringBuilder sb = new StringBuilder();
        sb.append("\n==========================================================\n");
        sb.append("                 BOOKING DETAILS (INVOICE)                \n");
        sb.append("==========================================================\n");
        
        // Header Section (ID & Status)
        sb.append(String.format("Booking ID: %-20s  Status: [%s]\n", booking.getId(), booking.getStatus()));
        sb.append("----------------------------------------------------------\n");

        // 1. Facility Information Section
        sb.append("FACILITY INFORMATION\n");
        sb.append("Facility:  ").append(facility.getName()).append("\n");
        sb.append("Type:      ").append(facility.getType()).append("\n");
        sb.append("Location:  ").append(facility.getName()).append(" (Building 1, Ground Floor)\n"); // Hardcoded location if not in Facility object, or use facility.toString() logic
        sb.append("Date:      ").append(booking.getDate()).append("\n");
        sb.append("Time:      ").append(booking.getTime()).append("\n");
        sb.append("\n");

        // 2. Member Information Section
        sb.append("MEMBER INFORMATION\n");
        sb.append("Name:      ").append(booking.getMemberName()).append("\n");
        sb.append("Email:     ").append(booking.getMemberEmail()).append("\n");
        sb.append("Phone:     ").append(booking.getMemberPhone()).append("\n");
        sb.append("\n");

        // 3. Cancellation Policy Section
        sb.append("CANCELLATION POLICY\n");
        sb.append("Warning: Cancelling this booking will refund the full amount to\n");
        sb.append("the member's original payment method.\n");
        sb.append("[ BUTTON: Cancel & Refund Booking ]\n");
        sb.append("\n");

        // 4. Payment Summary Section
        sb.append("PAYMENT SUMMARY\n");
        sb.append("Booked On:       ").append(booking.getBookedOn()).append("\n");
        sb.append("Payment Method:  ").append(booking.getPaymentMethod()).append("\n");
        sb.append("----------------------------------------------------------\n");
        sb.append(String.format("Facility Fee:    $%10.2f\n", facilityFee));
        sb.append(String.format("Service Fee:     $%10.2f\n", booking.getServiceFee()));
        sb.append("----------------------------------------------------------\n");
        sb.append(String.format("TOTAL PAID:      $%10.2f\n", total));
        sb.append("==========================================================\n");

        return sb.toString();
    }
}