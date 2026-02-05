// Rental.java - Represents a rental transaction
public class Rental {
    private String rentalId;
    private Customer customer;
    private Car car;
    private int days;
    private double totalCost;
    private boolean isActive;
    
    // Constructor
    public Rental(String rentalId, Customer customer, Car car, int days) {
        this.rentalId = rentalId;
        this.customer = customer;
        this.car = car;
        this.days = days;
        this.totalCost = car.getDailyRate() * days;
        this.isActive = true;
        
        // Mark car as rented
        car.setAvailable(false);
    }
    
    // Getter methods
    public String getRentalId() {
        return rentalId;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public Car getCar() {
        return car;
    }
    
    public int getDays() {
        return days;
    }
    
    public double getTotalCost() {
        return totalCost;
    }
    
    public boolean isActive() {
        return isActive;
    }
    
    // Method to return a car
    public void returnCar() {
        if (isActive) {
            isActive = false;
            car.setAvailable(true);
            System.out.println("Car returned successfully!");
        } else {
            System.out.println("This rental is already closed.");
        }
    }
    
    // Display rental details
    public void displayRentalInfo() {
        System.out.println("\n=== RENTAL DETAILS ===");
        System.out.println("Rental ID: " + rentalId);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Car: " + car.getMake() + " " + car.getModel());
        System.out.println("Days: " + days);
        System.out.println("Daily Rate: $" + car.getDailyRate());
        System.out.println("Total Cost: $" + totalCost);
        System.out.println("Status: " + (isActive ? "Active" : "Completed"));
        System.out.println("======================");
    }
}