package com.VehicleRental;

import com.VehicleRental.Class.*;
import com.VehicleRental.Exception.RentalNotAvailableException;

public class App {
    public static void main(String[] args) {
        // Create a rental agency
        RentalAgency agency = new RentalAgency();

        // Create vehicles
        Car car = new Car("CAR123", "Toyota Corolla");
        Motorcycle motorcycle = new Motorcycle("MOTO456", "Harley Davidson");
        Truck truck = new Truck("TRUCK789", "Ford F-150");

        // Add vehicles to the agency
        agency.addVehicle(car);
        agency.addVehicle(motorcycle);
        agency.addVehicle(truck);

        // Create customers
        Customer customer1 = new Customer("CUST001", "John Doe");
        Customer customer2 = new Customer("CUST002", "Jane Smith");

        // Register customers
        agency.registerCustomer(customer1);
        agency.registerCustomer(customer2);

        // Rent a vehicle to customer1
        try {
            System.out.println("Attempting to rent a car to " + customer1.getName() + "...");
            agency.rentVehicle(customer1, car, 5);
            System.out.println("Car rented successfully.");
        } catch (RentalNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        // Rent a motorcycle to customer2
        try {
            System.out.println("Attempting to rent a motorcycle to " + customer2.getName() + "...");
            agency.rentVehicle(customer2, motorcycle, 3);
            System.out.println("Motorcycle rented successfully.");
        } catch (RentalNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        // Attempt to rent the same car again
        try {
            System.out.println("Attempting to rent the same car to " + customer2.getName() + "...");
            agency.rentVehicle(customer2, car, 2);
        } catch (RentalNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        // Return the car
        System.out.println("Returning the car...");
        agency.returnVehicle(car);

        // Generate a report of the rental agency
        System.out.println("Generating rental agency report...");
        agency.generateReport();
    }
}