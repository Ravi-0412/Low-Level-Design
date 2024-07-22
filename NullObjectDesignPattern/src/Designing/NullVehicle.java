package Designing;


public class NullVehicle implements Vehicle{
	
	// in case of Null object
	// either do nothing or return default_value.
	// here returning default value i.e = 0.

    @Override
    public int getTankCapacity() {
        return 0;
    }

    @Override
    public int getSeatingCapacity() {
        return 0;
    }
}

