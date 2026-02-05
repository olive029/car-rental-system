// Main.java - Entry point of the application
public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Car Rental System...\n");
        
        // Start with login system (for assignment requirement)
        LoginSystems.main(args);
        
        // Alternative: Direct demo without login
        // System.out.println("Running direct demo...");
        // RentalAgency agency = new RentalAgency();
        // agency.runDemo();
        
        System.out.println("\nThank you for using Car Rental System!");
    }
}