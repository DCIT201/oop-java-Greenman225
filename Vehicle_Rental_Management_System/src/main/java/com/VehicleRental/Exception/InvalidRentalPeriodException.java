package com.VehicleRental.Exception;

public class InvalidRentalPeriodException extends RuntimeException {
    public InvalidRentalPeriodException(String message) {
        super(message);
    }
}