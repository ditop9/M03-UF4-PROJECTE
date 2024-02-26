package location;

import vehicles.Vehicle;

import java.util.ArrayList;

public abstract class Location {
    private final ArrayList<Vehicle> vehicleList = new ArrayList<>();
    private String cityLocation;
    private String countryLocation;
    private int workersAmount;

    public Location(String cityLocation, String countryLocation, int workersAmount) {
        this.cityLocation = cityLocation;
        this.countryLocation = countryLocation;
        this.workersAmount = workersAmount;
    }
    public abstract void addNewVehicle();
}
