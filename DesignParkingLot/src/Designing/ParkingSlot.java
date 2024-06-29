package Designing;

import Model.ParkingSlotType;
import Model.Vehicle;

public class ParkingSlot {
    private String name;
    private boolean isAvailable;
    private Vehicle vehicle;
    private ParkingSlotType parkingSlotType;

    // Constructor
    public ParkingSlot(String name, ParkingSlotType parkingSlotType) {
        this.name = name;
        this.isAvailable = true; // Default value
        this.parkingSlotType = parkingSlotType;
    }

    // Getters
    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSlotType getParkingSlotType() {
        return parkingSlotType;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setParkingSlotType(ParkingSlotType parkingSlotType) {
        this.parkingSlotType = parkingSlotType;
    }

    // Method to add a vehicle
    protected void addVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isAvailable = false;
    }

    // Method to remove a vehicle
    protected void removeVehicle(Vehicle vehicle) {
        this.vehicle = null;
        this.isAvailable = true;
    }
}