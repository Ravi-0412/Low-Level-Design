package Designing;



public class Main {

    public static void main(String args[]){

    	Vehicle vehicle = VehicleFactory.getVehicleObject("Car");
//        Vehicle vehicle = VehicleFactory.getVehicleObject("Bike");
        printVehicleDetails(vehicle);
    }
    
   /* without Null Object designing
    private static void printVehicleDetails(Vehicle vehicle) {
    	if(vehicle != null) {
    		System.out.println("Seating Capacity: " + vehicle.getSeatingCapacity());
    		System.out.println("Fuel Tank Capacity: " + vehicle.getTankCapacity());
    	} 	
}
*/

    private static void printVehicleDetails(Vehicle vehicle) {
            System.out.println("Seating Capacity: " + vehicle.getSeatingCapacity());
            System.out.println("Fuel Tank Capacity: " + vehicle.getTankCapacity());
    }
}

