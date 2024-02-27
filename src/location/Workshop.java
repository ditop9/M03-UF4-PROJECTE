package location;

import vehicles.Vehicle;

public class Workshop extends Location {
    public Workshop(String cityLocation, String countryLocation, int workersAmount) {
        super(cityLocation, countryLocation, workersAmount);
    }

    @Override
    public void addNewVehicle(Vehicle vehicle) {

    }
}
