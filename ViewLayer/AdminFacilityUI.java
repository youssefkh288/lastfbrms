package ViewLayer;

import ControllerLayer.FacilityController;
import DomainLayer.Facility;
import java.util.Scanner;

public class AdminFacilityUI {
    private FacilityController controller = new FacilityController();
    
    public void displayMenu(Scanner scanner) {
        while(true) {
            System.out.println("\n--- MANAGE FACILITIES (Admin) ---");
            System.out.println("1. View All Facilities");
            System.out.println("2. Add New Facility");
            System.out.println("0. Back");
            System.out.print("Choice: ");
            
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                if (choice == 0) break;
                
                if (choice == 1) {
                    printList();
                } else if (choice == 2) {
                    showAddForm(scanner);
                }
            } else {
                scanner.next();
            }
        }
    }

    private void printList() {
        System.out.println("\n--- Current Facilities ---");
        System.out.printf("%-10s | %-20s | %-10s | %-8s | %s%n", "ID", "Name", "Type", "Price", "Status");
        System.out.println("----------------------------------------------------------------------");
        for (Facility f : controller.getAllFacilities()) {
            System.out.printf("%-10s | %-20s | %-10s | $%-7.2f | %s%n", 
                f.getId(), f.getName(), f.getType(), f.getPrice(), f.getStatus());
        }
    }

    private void showAddForm(Scanner scanner) {
        System.out.println("\n=== ADD NEW FACILITY ===");
        
        // 1. Basic Information
        System.out.print("Facility Name: ");
        String name = scanner.nextLine();

        System.out.print("Facility Type (e.g. Sport, Meeting): ");
        String type = scanner.nextLine();

        System.out.print("Location (e.g. Building 1): ");
        String location = scanner.nextLine();

        System.out.print("Capacity (people): ");
        int capacity = scanner.nextInt();

        System.out.print("Price per Hour ($): ");
        double price = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.print("Description: ");
        String desc = scanner.nextLine();

        // Status Toggle
        System.out.print("Status (1=Active, 2=Inactive): ");
        String status = (scanner.nextInt() == 1) ? "Active" : "Inactive";
        scanner.nextLine(); 

        // 2. Amenities 
        System.out.println("Amenities (Available: WiFi, AC, Parking, Lockers, Projector, Sound System)");
        System.out.print("Type amenities separated by semicolon (e.g. WiFi;AC;Parking): ");
        String amenities = scanner.nextLine();

        // 3. Facility Image
        System.out.print("Image URL (Optional, press Enter to skip): ");
        String img = scanner.nextLine();
        if (img.isEmpty()) img = "default.jpg";

        // Save
        controller.addNewFacility(name, type, location, capacity, price, desc, status, amenities, img);
        
        // Success Message 
        System.out.println("\n>> SUCCESS: Facility '" + name + "' has been added to the system!");
    }
}