package Designing;


import java.util.List;
import java.util.Map;

import Model.Address;
import Model.ParkingSlotType;
import Model.Ticket;
import Model.Vehicle;

public class ParkingLot {
    private String nameOfParkingLot;
    private Address address;
    private List<ParkingFloor> parkingFloors;
    private static ParkingLot parkingLot = null;
    
    public String getNameOfParkingLot() {
		return nameOfParkingLot;
	}

	public void setNameOfParkingLot(String nameOfParkingLot) {
		this.nameOfParkingLot = nameOfParkingLot;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<ParkingFloor> getParkingFloors() {
		return parkingFloors;
	}

	public void setParkingFloors(List<ParkingFloor> parkingFloors) {
		this.parkingFloors = parkingFloors;
	}

	public static ParkingLot getParkingLot() {
		return parkingLot;
	}

	public static void setParkingLot(ParkingLot parkingLot) {
		ParkingLot.parkingLot = parkingLot;
	}

    private  ParkingLot(String nameOfParkingLot, Address address, List<ParkingFloor> parkingFloors) {
        this.nameOfParkingLot = nameOfParkingLot;
        this.address = address;
        this.parkingFloors = parkingFloors;
    }

    public static ParkingLot getInstance (String nameOfParkingLot, Address address, List<ParkingFloor> parkingFloors) {
        if(parkingLot == null){
            parkingLot = new ParkingLot(nameOfParkingLot,address,parkingFloors);
        }
        return parkingLot;
    }

    public void addFloors(String name, Map<ParkingSlotType, Map<String,ParkingSlot>> parkSlots){
        ParkingFloor parkingFloor = new ParkingFloor(name,parkSlots);
        parkingFloors.add(parkingFloor);
    }

    public void removeFloors(ParkingFloor parkingFloor){
        parkingFloors.remove(parkingFloor);
    }

    public Ticket assignTicket(Vehicle vehicle){
        //to assign ticket we need parking slot for this vehicle
        ParkingSlot parkingSlot = getParkingSlotForVehicleAndPark(vehicle);
        if(parkingSlot == null) return null;
        Ticket parkingTicket = createTicketForSlot(parkingSlot,vehicle);
        //persist ticket to database
        return parkingTicket;
    }

    public double scanAndPay(Ticket ticket){
        long endTime = System.currentTimeMillis();
        ticket.getParkingSlot().removeVehicle(ticket.getVehicle());
        int duration = (int) (endTime - ticket.getStartTime())/1000;
        double price = ticket.getParkingSlot().getParkingSlotType().getPriceForParking(duration);
        //persist record to database
        return price;
    }

    private Ticket createTicketForSlot(ParkingSlot parkingSlot, Vehicle vehicle) {
        return Ticket.createTicket(vehicle,parkingSlot);
    }

    private ParkingSlot getParkingSlotForVehicleAndPark(Vehicle vehicle) {
        ParkingSlot parkingSlot=null;
        // find the 1st empty slot for this vehicleType on any of the floor
        for(ParkingFloor floor : parkingFloors){
            parkingSlot = floor.getRelevantSlotForVehicleAndPark(vehicle);
            if(parkingSlot!= null) break;
        }
        return parkingSlot;
    }

}
