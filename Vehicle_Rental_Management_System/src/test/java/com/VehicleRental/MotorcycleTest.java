package com.VehicleRental;

import com.VehicleRental.Class.Motorcycle;
import com.VehicleRental.Class.Customer;
import junit.framework.TestCase;

public class MotorcycleTest extends TestCase {
    public void testMotorcycleRental() {
        Motorcycle motorcycle = new Motorcycle("MOTO456", "Harley Davidson");
        Customer customer = new Customer("CUST002", "Jane Smith");

        assertTrue(motorcycle.isAvailable());
        motorcycle.rent(customer, 3);
        assertFalse(motorcycle.isAvailable());

        motorcycle.returnVehicle();
        assertTrue(motorcycle.isAvailable());
    }

    public void testCalculateRentalCost() {
        Motorcycle motorcycle = new Motorcycle("MOTO456", "Harley Davidson");
        double cost = motorcycle.calculateRentalCost(3);
        assertEquals(72.0, cost); // 3 days * $30/day * 0.8 (discount)
    }
}