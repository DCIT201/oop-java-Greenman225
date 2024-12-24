package com.VehicleRental;

import com.VehicleRental.Class.Car;
import com.VehicleRental.Class.Customer;
import junit.framework.TestCase;

public class CarTest extends TestCase {
    public void testCarRental() {
        Car car = new Car("CAR123", "Toyota Corolla");
        Customer customer = new Customer("CUST001", "John Doe");

        assertTrue(car.isAvailable());
        car.rent(customer, 5);
        assertFalse(car.isAvailable());

        car.returnVehicle();
        assertTrue(car.isAvailable());
    }

    public void testCalculateRentalCost() {
        Car car = new Car("CAR123", "Toyota Corolla");
        double cost = car.calculateRentalCost(3);
        assertEquals(150.0, cost); // 3 days * $50/day
    }
}
