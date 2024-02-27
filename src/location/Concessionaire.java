package location;

import vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Concessionaire extends Location {
    private final List<Vehicle> availableVehicles = new ArrayList<>();
    private String mainBrand;
    private boolean sellSecondHandVehicle;
    public Concessionaire(String cityLocation, String countryLocation, int workersAmount, String mainBrand, boolean sellSecondHandVehicle) {
        super(cityLocation, countryLocation, workersAmount);
        this.mainBrand = mainBrand;
        this.sellSecondHandVehicle = sellSecondHandVehicle;
    }

    @Override
    public void addNewVehicle(Vehicle v) {
        availableVehicles.add(v);
    }
}
