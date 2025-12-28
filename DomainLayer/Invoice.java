package DomainLayer;

import java.util.UUID;

public class Invoice {
    private String invoiceID;
    private String bookingID;
    private double amount;
    private String issueDate;

    public Invoice(String bookingID, double amount, String issueDate) {
        this.invoiceID = UUID.randomUUID().toString().substring(0, 8); // Auto-gen ID
        this.bookingID = bookingID;
        this.amount = amount;
        this.issueDate = issueDate;
    }

    // View formatting logic can live here or in the UI. 
    // Keeping it here keeps the UI "dumb".
    public String printInvoice() {
        return "----------------------------\n" +
               " INVOICE #" + invoiceID + "\n" +
               " Booking Ref: " + bookingID + "\n" +
               " Date: " + issueDate + "\n" +
               " TOTAL AMOUNT: $" + amount + "\n" +
               "----------------------------";
    }
}