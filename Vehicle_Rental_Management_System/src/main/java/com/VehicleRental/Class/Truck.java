package com.VehicleRental.Class;

import com.VehicleRental.Interface.Rentable;

public class Truck extends Vehicle implements Rentable {
    public Truck(String vehicleId, String model) {
        super(vehicleId, model, 80.0); // Base rental rate for Truck
    }

    @Override
    public double calculateRentalCost(int days) {
        return (days * getBaseRentalRate()) + 50; // Extra fee for heavy vehicles
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        if (isAvailable()) {
            System.out.println("Truck rented to " + customer.getName() + " for " + days + " days.");
            setAvailable(false);
            customer.addRental(this);
        } else {
            System.out.println("Truck is not available for rental.");
        }
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Truck has been returned.");
    }
}