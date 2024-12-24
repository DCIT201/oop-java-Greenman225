package com.VehicleRental.Class;

import java.time.LocalDateTime;

public class RentalTransaction {
    private Customer customer;
    private Vehicle vehicle;
    private final int rentalDuration; // in days
    private LocalDateTime rentalDate;

    public RentalTransaction(Customer customer, Vehicle vehicle, int rentalDuration) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalDuration = rentalDuration;
        this.rentalDate = LocalDateTime.now();
    }

    public Customer getCustomer() {
        return customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public LocalDateTime getRentalDate() {
        return rentalDate;
    }

    @Override
    public String toString() {
        return "RentalTransaction{" +
                "customer=" + customer.getName() +
                ", vehicle=" + vehicle.getModel() +
                ", rentalDuration=" + rentalDuration +
                ", rentalDate=" + rentalDate +
                '}';
    }
}