package location;

import vehicles.Vehicle;

public class Workshop extends Location {
    private String name;

    public String getName() {
        return name;
    }

    public Workshop(String cityLocation, String countryLocation, int workersAmount, String name) {
        super(cityLocation, countryLocation, workersAmount);
        this.name = name;
    }

    @Override
    public void addNewVehicle(Vehicle vehicle) {

    }

    @Override
    public String toString() {
        return "Concessionari: " + "\n" +
                "Nom: " + name + "\n" +
                super.toString();
    }
}
