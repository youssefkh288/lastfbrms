package ViewLayer;

import ControllerLayer.BookingController;
import ControllerLayer.InvoiceController;
import DomainLayer.Facility;
import DomainLayer.Invoice;
import java.util.List;
import java.util.Scanner;

public class BookingUI {
    private BookingController bookingCtrl = new BookingController();
    private InvoiceController invoiceCtrl = new InvoiceController();

    public void displayMenu(Scanner scanner) {
        while(true) {
            System.out.println("\n--- BOOKING & FINANCE ---");
            System.out.println("1.  View Availability");
            System.out.println("2.  Generate Invoice");
            System.out.println("0. Back");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) break;

            if (choice == 1) {
                System.out.print("Enter Date (e.g. 2025-12-28): ");
                String date = scanner.nextLine();
                System.out.print("Enter Time (e.g. 10:00): ");
                String time = scanner.nextLine();
                
                List<Facility> available = bookingCtrl.getAvailableFacilities(date, time);
                System.out.println("\nAvailable Facilities:");
                if (available.isEmpty()) System.out.println("None.");
                for (Facility f : available) {
                    System.out.println("- " + f.getName());
                }
            }
            else if (choice == 2) {
                System.out.print("Enter Booking ID (e.g. BK12345678): ");
                String bId = scanner.nextLine();
                Invoice inv = invoiceCtrl.generateInvoice(bId);
                
                if (inv != null) {
                    System.out.println(inv.printInvoice());
                } else {
                    System.out.println("Booking not found.");
                }
            }
        }
    }
}