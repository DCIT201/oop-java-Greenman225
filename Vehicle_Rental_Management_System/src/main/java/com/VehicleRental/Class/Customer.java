package com.VehicleRental.Class;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String customerId;
    private final String name;
    private final List<Vehicle> rentalHistory;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.rentalHistory = new ArrayList<>();
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public List<Vehicle> getRentalHistory() {
        return rentalHistory;
    }

    public void addRental(Vehicle vehicle) {
        rentalHistory.add(vehicle);
    }

    public boolean isEligibleForRental() {
        // Implement eligibility checks based on rental history or other criteria
        return true; // Placeholder for actual logic
    }
}