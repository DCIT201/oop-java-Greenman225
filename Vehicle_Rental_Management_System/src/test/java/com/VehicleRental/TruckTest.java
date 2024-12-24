package com.VehicleRental;

import com.VehicleRental.Class.Truck;
import com.VehicleRental.Class.Customer;
import junit.framework.TestCase;

public class TruckTest extends TestCase {
    public void testTruckRental() {
        Truck truck = new Truck("TRUCK789", "Ford F-150");
        Customer customer = new Customer("CUST003", "Alice Johnson");

        assertTrue(truck.isAvailable());
        truck.rent(customer, 2);
        assertFalse(truck.isAvailable());

        truck.returnVehicle();
        assertTrue(truck.isAvailable());
    }

    public void testCalculateRentalCost() {
        Truck truck = new Truck("TRUCK789", "Ford F-150");
        double cost = truck.calculateRentalCost(2);
        assertEquals(210.0, cost); // 2 days * $80/day + $50 (extra fee)
    }
}