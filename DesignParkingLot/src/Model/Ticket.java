package Model;

import Designing.ParkingSlot;

public class Ticket {
    private String ticketNumber;
    private long startTime;
    private long endTime;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;

    // Constructor
    public Ticket(String ticketNumber, long startTime, long endTime, Vehicle vehicle, ParkingSlot parkingSlot) {
        this.ticketNumber = ticketNumber;
        this.startTime = startTime;
        this.endTime = endTime;
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
    }

    // Getters
    public String getTicketNumber() {
        return ticketNumber;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    // Setters
    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    // Static method to create a ticket
    public static Ticket createTicket(Vehicle vehicle, ParkingSlot parkingSlot) {
        long currentTime = System.currentTimeMillis();
        String ticketNumber = vehicle.getVehicleNumber() + currentTime;
        return new Ticket(ticketNumber, currentTime, 0, vehicle, parkingSlot);
    }
}
