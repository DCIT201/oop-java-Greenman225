package com.VehicleRental.Class;

import com.VehicleRental.Exception.RentalNotAvailableException;

import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private final  List<Vehicle> vehicles;
    private final List<Customer> customers;
    private List<RentalTransaction> transactions;

    public RentalAgency() {
        vehicles = new ArrayList<>();
        customers = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void registerCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentVehicle(Customer customer, Vehicle vehicle, int rentalDuration) throws RentalNotAvailableException {
        if (!vehicles.contains(vehicle) || !vehicle.isAvailable()) {
            throw new RentalNotAvailableException("Vehicle is not available for rent.");
        }
        vehicle.setAvailable(false); // Mark the vehicle as rented
        RentalTransaction transaction = new RentalTransaction(customer, vehicle, rentalDuration);
        transactions.add(transaction);
    }

    public void returnVehicle(Vehicle vehicle) {
        vehicle.setAvailable(true); // Mark the vehicle as available
        // Optionally, you can also remove the transaction or keep it for records
    }

    public void generateReport() {
        System.out.println("Rental Agency Report:");
        for (RentalTransaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}