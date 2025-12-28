package ViewLayer;

import java.util.Scanner;

public class MainDashboardUI {
    private AdminFacilityUI adminUI = new AdminFacilityUI();
    private BookingUI bookingUI = new BookingUI();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("System Started...");
        
        while(true) {
            System.out.println("\n=== MAIN DASHBOARD ===");
            System.out.println("1. Manage Facilities (Admin)");
            System.out.println("2. Booking & Finance (Member)");
            System.out.println("0. Exit");
            System.out.print("Select: ");
            
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1: adminUI.displayMenu(scanner); break;
                    case 2: bookingUI.displayMenu(scanner); break;
                    case 0: System.exit(0);
                    default: System.out.println("Invalid option.");
                }
            } else {
                scanner.next(); 
            }
        }
    }
}