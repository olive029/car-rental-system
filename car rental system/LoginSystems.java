// LoginSystem.java - Handles user login with password masking
import java.util.Scanner;

public class LoginSystems {
    // Valid credentials
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password123";
    private static final int MAX_ATTEMPTS = 3;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        boolean loggedIn = false;
        
        System.out.println("==========================================");
        System.out.println("      CAR RENTAL SYSTEM - LOGIN");
        System.out.println("==========================================");
        System.out.println("Default: admin / password123");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts");
        System.out.println();
        
        // Login loop
        while (attempts < MAX_ATTEMPTS && !loggedIn) {
            System.out.println("Attempt " + (attempts + 1) + " of " + MAX_ATTEMPTS);
            System.out.println("------------------------------------------");
            
            // Get username
            System.out.print("Username: ");
            String username = scanner.nextLine();
            
            // Get password with masking
            System.out.print("Password: ");
            String password = getMaskedPassword(scanner);
            
            // Validate credentials
            if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
                loggedIn = true;
                System.out.println("\n==========================================");
                System.out.println("       LOGIN SUCCESSFUL!");
                System.out.println("Welcome, " + username + "!");
                System.out.println("==========================================");
                System.out.println("// COMMENT: Login successful on attempt " + (attempts + 1));
                
                // Start the car rental system
                startCarRentalSystem();
            } else {
                attempts++;
                System.out.println("\nInvalid username or password!");
                
                if (attempts < MAX_ATTEMPTS) {
                    System.out.println("// COMMENT: " + (MAX_ATTEMPTS - attempts) + " attempt(s) remaining");
                } else {
                    System.out.println("// COMMENT: Maximum attempts reached. Access denied.");
                }
                System.out.println();
            }
        }
        
        // If login failed
        if (!loggedIn) {
            System.out.println("==========================================");
            System.out.println("         ACCESS DENIED");
            System.out.println("System locked. Contact administrator.");
            System.out.println("==========================================");
        }
        
        scanner.close();
    }
    
    /**
     * Simulates password masking for VS Code compatibility
     * Shows asterisks for each character after input
     */
    private static String getMaskedPassword(Scanner scanner) {
        // Read password
        String password = scanner.nextLine();
        
        // Show asterisks for each character
        System.out.print("You entered: ");
        for (int i = 0; i < password.length(); i++) {
            System.out.print("*");
        }
        System.out.println();
        
        return password;
    }
    
    /**
     * Starts the main car rental system
     */
    private static void startCarRentalSystem() {
        System.out.println("\n==========================================");
        System.out.println("   CAR RENTAL MANAGEMENT SYSTEM");
        System.out.println("==========================================");
        
        // Create and run rental agency
        RentalAgency agency = new RentalAgency();
        agency.runDemo();
        
        System.out.println("\nSystem ready for operations!");
    }
}