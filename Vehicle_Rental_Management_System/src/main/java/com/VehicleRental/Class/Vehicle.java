package com.VehicleRental.Class;


import com.VehicleRental.Interface.Rentable;

public abstract class Vehicle implements Rentable {
    private final String vehicleId;
    private final String model;
    private final double baseRentalRate;
    private boolean isAvailable;

    public Vehicle(String vehicleId, String model, double baseRentalRate) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
        this.isAvailable = true;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public double getBaseRentalRate() {
        return baseRentalRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public abstract double calculateRentalCost(int days);
    public abstract boolean isAvailableForRental();

    // Abstract methods for renting and returning vehicles
    public abstract void rent(Customer customer, int days);
    public abstract void returnVehicle();

    @Override
    public String toString() {
        return "Vehicle ID: " + vehicleId + ", Model: " + model +
                ", Base Rental Rate: $" + baseRentalRate +
                ", Available: " + isAvailable;
    }
}
