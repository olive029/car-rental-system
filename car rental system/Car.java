// Car.java - Represents a car in the rental system
public class Car {
    // Private fields for encapsulation
    private String carId;
    private String make;
    private String model;
    private int year;
    private double dailyRate;
    private boolean isAvailable;
    
    // Constructor
    public Car(String carId, String make, String model, int year, double dailyRate) {
        this.carId = carId;
        this.make = make;
        this.model = model;
        this.year = year;
        this.dailyRate = dailyRate;
        this.isAvailable = true; // Cars are available by default
    }
    
    // Getter methods
    public String getCarId() {
        return carId;
    }
    
    public String getMake() {
        return make;
    }
    
    public String getModel() {
        return model;
    }
    
    public int getYear() {
        return year;
    }
    
    public double getDailyRate() {
        return dailyRate;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    // Setter for availability
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    
    // Display car information
    public void displayCarInfo() {
        System.out.println("Car ID: " + carId);
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Daily Rate: $" + dailyRate);
        System.out.println("Status: " + (isAvailable ? "Available" : "Rented"));
        System.out.println("------------------------");
    }
}