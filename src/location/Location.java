package location;

import vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Location {
    private final List<Vehicle> vehicleList = new ArrayList<>();
    private final int id;
    private String cityLocation;
    private String countryLocation;
    private int workersAmount;

    public int getId() {
        return id;
    }

    public void setCityLocation(String cityLocation) {
        this.cityLocation = cityLocation;
    }

    public void setCountryLocation(String countryLocation) {
        this.countryLocation = countryLocation;
    }

    public void setWorkersAmount(int workersAmount) {
        this.workersAmount = workersAmount;
    }

    public Location(String cityLocation, String countryLocation, int workersAmount) {
        this.cityLocation = cityLocation;
        this.countryLocation = countryLocation;
        this.workersAmount = workersAmount;
        Random random = new Random();
        this.id = random.nextInt();
    }
    public abstract void addNewVehicle(Vehicle vehicle);
    public abstract void showAvailableVehicles();
    public abstract void repairVehicle(int index);
    @Override
    public String toString() {
        return "Ciutat: " + cityLocation + "\n" +
                "País: " + countryLocation + "\n" +
                "Treballadors: " + workersAmount + "\n" +
                "_____________________________";
    }
}
