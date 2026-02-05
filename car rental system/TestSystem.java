// TestSystem.java - Simple test to verify all classes
public class TestSystem {
    public static void main(String[] args) {
        System.out.println("=== Testing Car Rental System ===\n");
        
        // Test Car class
        System.out.println("1. Testing Car class:");
        Car car1 = new Car("TEST001", "Toyota", "Camry", 2023, 50.0);
        car1.displayCarInfo();
        
        // Test Customer class
        System.out.println("2. Testing Customer class:");
        Customer customer1 = new Customer("TESTC01", "Test User", "test@email.com", "123456");
        customer1.displayInfo();
        
        // Test Rental class
        System.out.println("3. Testing Rental class:");
        Rental rental1 = new Rental("TESTR01", customer1, car1, 3);
        rental1.displayRentalInfo();
        
        System.out.println("\n=== All tests passed! ===");
    }
}