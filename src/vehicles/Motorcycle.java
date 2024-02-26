package vehicles;

import vehicles.Vehicle;

public class Motorcycle extends Vehicle {
    private String type;
    public Motorcycle(String plate, char fuel, int tireQuantity, int horsePower) {
        super(plate, fuel, 2, horsePower);
    }
}
