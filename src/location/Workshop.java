package location;

import vehicles.Vehicle;

import java.util.ArrayList;

public class Workshop extends Location {
    public Workshop(String cityLocation, String countryLocation, int workersAmount) {
        super(cityLocation, countryLocation, workersAmount);
    }

    @Override
    public void addNewVehicle() {

    }
}
