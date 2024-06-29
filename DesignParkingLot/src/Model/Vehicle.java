package Model;

import java.util.Objects;

public class Vehicle {
    String vehicleNumber;
    VehicleCategory vehicleCategory;
    
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public VehicleCategory getVehicleCategory() {
		return vehicleCategory;
	}
	
	public void setVehicleCategory(VehicleCategory vehicleCategory) {
		this.vehicleCategory = vehicleCategory;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(vehicleNumber);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return Objects.equals(vehicleNumber, other.vehicleNumber);
	}
}