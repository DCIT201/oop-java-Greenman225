package com.VehicleRental;

import com.VehicleRental.Class.Customer;
import com.VehicleRental.Class.Car;
import junit.framework.TestCase;

public class CustomerTest extends TestCase {
    public void testCustomerRentalHistory() {
        Customer customer = new Customer("CUST001", "John Doe");
        Car car = new Car("CAR123", "Toyota Corolla");

        assertTrue(customer.getRentalHistory().isEmpty());
        customer.addRental(car);
        assertEquals(1, customer.getRentalHistory().size());
        assertEquals(car, customer.getRentalHistory().get(0));
    }
}