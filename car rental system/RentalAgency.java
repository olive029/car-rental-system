// RentalAgency.java - Main system manager
import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;
    
    // Constructor
    public RentalAgency() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
        initializeSampleData();
    }
    
    // Initialize with sample data
    private void initializeSampleData() {
        System.out.println("Initializing rental agency with sample data...\n");
        
        // Add sample cars
        cars.add(new Car("C001", "Toyota", "Camry", 2022, 50.0));
        cars.add(new Car("C002", "Honda", "Civic", 2023, 45.0));
        cars.add(new Car("C003", "Ford", "Mustang", 2021, 80.0));
        cars.add(new Car("C004", "Tesla", "Model 3", 2023, 100.0));
        
        // Add sample customers
        customers.add(new Customer("CT001", "Olive Wambui", "omunjogu@email.com", "123-456-7890"));
        customers.add(new Customer("CT002", "Jane Brown", "jane@email.com", "098-765-4321"));
    }
    
    // Display all available cars
    public void displayAvailableCars() {
        System.out.println("\n=== AVAILABLE CARS ===");
        boolean foundAvailable = false;
        
        for (Car car : cars) {
            if (car.isAvailable()) {
                car.displayCarInfo();
                foundAvailable = true;
            }
        }
        
        if (!foundAvailable) {
            System.out.println("No cars available at the moment.");
        }
    }
    
    // Display all customers
    public void displayAllCustomers() {
        System.out.println("\n=== ALL CUSTOMERS ===");
        if (customers.isEmpty()) {
            System.out.println("No customers registered.");
        } else {
            for (Customer customer : customers) {
                customer.displayInfo();
            }
        }
    }
    
    // Display all rentals
    public void displayAllRentals() {
        System.out.println("\n=== ALL RENTALS ===");
        if (rentals.isEmpty()) {
            System.out.println("No rentals yet.");
        } else {
            for (Rental rental : rentals) {
                rental.displayRentalInfo();
            }
        }
    }
    
    // Rent a car
    public void rentCar(String customerId, String carId, int days) {
        // Find customer
        Customer customer = null;
        for (Customer c : customers) {
            if (c.getCustomerId().equals(customerId)) {
                customer = c;
                break;
            }
        }
        
        // Find car
        Car car = null;
        for (Car c : cars) {
            if (c.getCarId().equals(carId) && c.isAvailable()) {
                car = c;
                break;
            }
        }
        
        // Check if both found
        if (customer == null) {
            System.out.println("Error: Customer not found!");
            return;
        }
        
        if (car == null) {
            System.out.println("Error: Car not found or not available!");
            return;
        }
        
        // Create rental
        String rentalId = "R" + (rentals.size() + 1);
        Rental rental = new Rental(rentalId, customer, car, days);
        rentals.add(rental);
        
        System.out.println("\nRental successful!");
        rental.displayRentalInfo();
    }
    
    // Return a car
    public void returnCar(String rentalId) {
        for (Rental rental : rentals) {
            if (rental.getRentalId().equals(rentalId) && rental.isActive()) {
                rental.returnCar();
                return;
            }
        }
        System.out.println("Rental not found or already returned.");
    }
    
    // Run a demo of the system
    public void runDemo() {
        System.out.println("\n==========================================");
        System.out.println("        CAR RENTAL SYSTEM DEMO");
        System.out.println("==========================================");
        
        // Show initial state
        displayAvailableCars();
        displayAllCustomers();
        
        // Make a rental
        System.out.println("\n>> Making a rental...");
        rentCar("CT001", "C001", 5);
        
        // Try to rent same car (should fail)
        System.out.println("\n>> Trying to rent same car...");
        rentCar("CT002", "C001", 3);
        
        // Rent another car
        System.out.println("\n>> Renting another car...");
        rentCar("CT002", "C002", 7);
        
        // Show current state
        System.out.println("\n>> Current available cars:");
        displayAvailableCars();
        
        System.out.println("\n>> All rentals:");
        displayAllRentals();
        
        // Return a car
        System.out.println("\n>> Returning rental R1...");
        returnCar("R1");
        
        // Final state
        System.out.println("\n>> Final available cars:");
        displayAvailableCars();
        
        System.out.println("\n==========================================");
        System.out.println("           DEMO COMPLETE");
        System.out.println("==========================================");
    }
}