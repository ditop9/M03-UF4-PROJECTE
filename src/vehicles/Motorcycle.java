package vehicles;

public class Motorcycle extends Vehicle {
    private int fuelQuantity;
    private int cylinder;
    public Motorcycle(String plate, char fuel, int tireQuantity, int horsePower, String type, int fuelQuantity, int cylinder) {
        super(plate, fuel, 2, horsePower, type);
        this.fuelQuantity = fuelQuantity;
        this.cylinder = cylinder;
    }
}
