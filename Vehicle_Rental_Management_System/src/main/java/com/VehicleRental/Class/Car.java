package com.VehicleRental.Class;

import com.VehicleRental.Interface.Rentable;

public class Car extends Vehicle {
    public Car(String vehicleId, String model) {
        super(vehicleId, model, 50.0); // Base rental rate for Car
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * getBaseRentalRate();
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        if (isAvailable()) {
            System.out.println("Car rented to " + customer.getName() + " for " + days + " days.");
            setAvailable(false);
            customer.addRental(this);
        } else {
            System.out.println("Car is not available for rental.");
        }
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Car has been returned.");
    }
}