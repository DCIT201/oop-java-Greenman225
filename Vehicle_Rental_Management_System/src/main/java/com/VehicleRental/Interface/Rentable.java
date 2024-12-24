package com.VehicleRental.Interface;

import com.VehicleRental.Class.Customer;

public interface Rentable {
    void rent(Customer customer, int days);
    void returnVehicle();
}