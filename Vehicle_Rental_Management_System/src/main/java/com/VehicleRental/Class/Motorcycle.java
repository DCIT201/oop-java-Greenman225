package com.VehicleRental.Class;

import com.VehicleRental.Interface.Rentable;

public class Motorcycle extends Vehicle {
    public Motorcycle(String vehicleId, String model) {
        super(vehicleId, model, 30.0); // Base rental rate for Motorcycle
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * getBaseRentalRate() * 0.8; // Discounted rate for motorcycles
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        if (isAvailable()) {
            System.out.println("Motorcycle rented to " + customer.getName() + " for " + days + " days.");
            setAvailable(false);
            customer.addRental(this);
        } else {
            System.out.println("Motorcycle is not available for rental.");
        }
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Motorcycle has been returned.");
    }
}