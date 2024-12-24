package com.VehicleRental;

import junit.framework.TestCase;
import com.VehicleRental.Class.*;
import com.VehicleRental.Exception.RentalNotAvailableException;

public class AppTest extends TestCase {

    private RentalAgency agency;
    private Car car;
    private Motorcycle motorcycle;
    private Truck truck;
    private Customer customer1;
    private Customer customer2;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        // Initialize the RentalAgency and vehicles before each test
        agency = new RentalAgency();
        car = new Car("CAR123", "Toyota Corolla", 50.0);
        motorcycle = new Motorcycle("MOTO456", "Harley Davidson", 30.0);
        truck = new Truck("TRUCK789", "Ford F-150", 70.0);

        // Add vehicles to the agency
        agency.addVehicle(car);
        agency.addVehicle(motorcycle);
        agency.addVehicle(truck);

        // Create customers
        customer1 = new Customer("CUST001", "John Doe");
        customer2 = new Customer("CUST002", "Jane Smith");

        // Register customers
        agency.registerCustomer(customer1);
        agency.registerCustomer(customer2);
    }

    public void testRentVehicleSuccessfully() {
        try {
            agency.rentVehicle(customer1, car, 5);
            assertFalse("Car should be rented", car.isAvailable());
        } catch (RentalNotAvailableException e) {
            fail("Rental should be available, but got exception: " + e.getMessage());
        }
    }

    public void testRentVehicleNotAvailable() {
        try {
            agency.rentVehicle(customer1, car, 5); // Rent the car first
            agency.rentVehicle(customer2, car, 3); // Try to rent the same car
            fail("Expected RentalNotAvailableException was not thrown.");
        } catch (RentalNotAvailableException e) {
            assertEquals("Vehicle is not available for rent.", e.getMessage());
        }
    }

    public void testReturnVehicle() {
        try {
            agency.rentVehicle(customer1, car, 5);
            agency.returnVehicle(car);
            assertTrue("Car should be available after return", car.isAvailable());
        } catch (RentalNotAvailableException e) {
            fail("Rental should be available, but got exception: " + e.getMessage());
        }
    }

    public void testRentingMultipleVehicles() {
        try {
            agency.rentVehicle(customer1, car, 5);
            agency.rentVehicle(customer2, motorcycle, 3);
            assertFalse("Car should be rented", car.isAvailable());
            assertFalse("Motorcycle should be rented", motorcycle.isAvailable());
        } catch (RentalNotAvailableException e) {
            fail("Rental should be available, but got exception: " + e.getMessage());
        }
    }
}