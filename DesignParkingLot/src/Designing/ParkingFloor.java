package Designing;

import java.util.Map;

import Model.ParkingSlotType;
import Model.Vehicle;
import Model.VehicleCategory;

public class ParkingFloor {
    String name;
    Map<ParkingSlotType,Map<String,ParkingSlot>> parkingSlots;
    
    // jb parking floor create karenge tb parking slots bhi create karna hoga
    // like is floor pe kitna tarah ka vehicle park kar sakte and uska number
    public ParkingFloor(String name , Map<ParkingSlotType,Map<String,ParkingSlot>> parkingSlots) {
        this.name=name;
        this.parkingSlots = parkingSlots;
    }
    
    // kis floor parkingslot available h parkingSlot available h is vehicle ke liye
    public ParkingSlot getRelevantSlotForVehicleAndPark(Vehicle vehicle) {
    	// 1st we will need the category of this vehicle like TwoWheeler, car, sedan etc.
        VehicleCategory vehicleCategory = vehicle.getVehicleCategory();
        // uske bad is vehicle ka 'parkingSlotType' chahiye like TwoWheeler, compact,medium ,large etc.
        ParkingSlotType parkingSlotType = pickCorrectSlot(vehicleCategory);
        // ab is 'parkingSlotType' me search karna hoga ki kon sa slot khali h one by one.
        Map<String,ParkingSlot> relevantParkingSlot = parkingSlots.get(parkingSlotType);
        ParkingSlot slot =null ;
        for(Map.Entry<String,ParkingSlot> m : relevantParkingSlot.entrySet()){
            if(m.getValue().isAvailable()) {
            	// agar slot available h then us jagah pe vehicle add kar dena h.
                slot = m.getValue();
                slot.addVehicle(vehicle);
                break;
            }
        }

        return slot;  // return to the parkingLot to park the vehicle at this slot
    }
    
    // har vehicle like TwoWheeler, sedan, suv ke corresponding ek 'parkingSlotType' dega like TwoWheeler, compact, medium etc.
    // just we are mapping vehicleType -> parkingSlotType
    private ParkingSlotType pickCorrectSlot(VehicleCategory vehicleCategory) {
        if(vehicleCategory.equals(VehicleCategory.TwoWheeler)) return ParkingSlotType.TwoWheeler;
        else if(vehicleCategory.equals(VehicleCategory.Hatchback) || vehicleCategory.equals(VehicleCategory.Sedan)) return ParkingSlotType.Compact;
        else if(vehicleCategory.equals(VehicleCategory.SUV)) return ParkingSlotType.Medium;
        else if(vehicleCategory.equals(VehicleCategory.Bus)) return ParkingSlotType.Large;

        return null;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<ParkingSlotType, Map<String, ParkingSlot>> getParkingSlots() {
		return parkingSlots;
	}

	public void setParkingSlots(Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlots) {
		this.parkingSlots = parkingSlots;
	}
}
